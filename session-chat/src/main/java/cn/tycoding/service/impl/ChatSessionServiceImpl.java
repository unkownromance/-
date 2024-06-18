package cn.tycoding.service.impl;

import cn.tycoding.constant.CommonConstant;
import cn.tycoding.entity.Message;
import cn.tycoding.entity.ChatUser;
import cn.tycoding.service.ChatSessionService;
import cn.tycoding.utils.CoreUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Slf4j
@Service
public class ChatSessionServiceImpl implements ChatSessionService {

    @Override
    public void pushMessage(String fromId, String toId, String message, HttpSession session) {
        Object user = session.getAttribute(fromId);
        if (user instanceof ChatUser) {
            Message entity = new Message();
            entity.setMessage(message);
            entity.setFrom((ChatUser) user);
            entity.setTime(CoreUtil.format(new Date()));
            if (toId != null) {
                //查询接收方信息
                Object to = session.getAttribute(toId);
                if (to instanceof ChatUser) {
                    entity.setTo((ChatUser) to);
                }
                //单个用户推送
                push(entity, CommonConstant.CHAT_FROM_PREFIX + fromId + CommonConstant.CHAT_TO_PREFIX + toId, session);
            } else {
                //公共消息 -- 群组
                entity.setTo(null);
                push(entity, CommonConstant.CHAT_COMMON_PREFIX + fromId, session);
            }

        }
    }

    /**
     * 推送消息
     *
     * @param entity  Session value
     * @param key     Session key
     * @param session HttpSession
     */
    private void push(Message entity, String key, HttpSession session) {
        //这里按照 PREFIX_ID 格式，作为KEY储存消息记录
        //但一个用户可能推送很多消息，VALUE应该是数组
        List<Message> list = new ArrayList<Message>();
        Object msg = session.getAttribute(key);
        if (msg == null) {
            //第一次推送消息
            list.add(entity);
        } else {
            //第n次推送消息
//            if (msg instanceof List) {
                list = (List<Message>) msg;
                list.add(entity);
//            }
        }
        session.setAttribute(key, list);
    }

    @Override
    public List<ChatUser> onlineList(HttpSession session) {
        List<ChatUser> list = new ArrayList<ChatUser>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            if (session.getAttribute(id) instanceof ChatUser) {
                list.add((ChatUser) session.getAttribute(id));
            }
        }
        return list;
    }

    @Override
    public List<Message> commonList(HttpSession session) {
        List<Message> list = new ArrayList<Message>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            //指定前缀标识
            if (id.startsWith(CommonConstant.CHAT_COMMON_PREFIX)) {
                Object attribute = session.getAttribute(id);
                if (attribute instanceof List) {
                    List<Message> data = (List<Message>) attribute;
                    list.addAll(data);
                    CoreUtil.push(list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Message> selfList(String fromId, String toId, HttpSession session) {
        List<Message> list = new ArrayList<Message>();
        Enumeration<String> ids = session.getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            //指定前缀标识
            if (id.startsWith(CommonConstant.CHAT_FROM_PREFIX) || id.indexOf(CommonConstant.CHAT_TO_PREFIX) > 0) {
                Object attribute = session.getAttribute(id);
                if (attribute instanceof List) {
                    //list = (List<Message>) attribute;
                    List<Message> data= (List<Message>) attribute;
                    list.addAll(data);
                    CoreUtil.push(list);
                }
            }
        }
        return list;
    }
}
