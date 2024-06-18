package cn.tycoding.controller;

import cn.tycoding.entity.Message;
import cn.tycoding.entity.ChatUser;
import cn.tycoding.service.ChatSessionService;
import cn.tycoding.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatSessionService chatSessionService;

    /**
     * 获取当前窗口用户信息
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/{id}")
    public R info(@PathVariable("id") String id, HttpServletRequest request) {
        ChatUser user = new ChatUser();
        //从类ChatUser中得到Session对象的id值
        if (request.getSession().getAttribute(id) instanceof ChatUser) {
            user = (ChatUser) request.getSession().getAttribute(id);
        }
        return new R(user);
    }

    /**
     * 向指定窗口推送消息
     *
     * @param toId 接收方ID
     * @param message 消息
     * @return
     */
    @PostMapping("/push/{toId}")
    public R push(@PathVariable("toId") String toId, @RequestBody Message message, HttpServletRequest request) {
        try {
            WebsocketServerEndpoint endpoint = new WebsocketServerEndpoint();
            endpoint.sendTo(toId, message, request.getSession());
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            return new R(500, "消息推送失败");
        }
    }

    /**
     * 获取在线用户列表
     *
     * @param request 从Session中获取
     * @return
     */
    @GetMapping("/online/list")
    public R onlineList(HttpServletRequest request) {
        List<ChatUser> list = chatSessionService.onlineList(request.getSession());
        return new R(list);
    }

    /**
     * 获取公共聊天消息内容
     *
     * @param request 从Session中获取
     * @return
     */
    @GetMapping("/common")
    public R commonList(HttpServletRequest request) {
        List<Message> list = chatSessionService.commonList(request.getSession());
        return new R(list);
    }

    /**
     * 获取指定用户的聊天消息内容
     *
     * @param fromId  该用户ID
     * @param toId    哪个窗口
     * @param request 从Session中获取
     * @return
     */
    @GetMapping("/self/{fromId}/{toId}")
    public R selfList(@PathVariable("fromId") String fromId, @PathVariable("toId") String toId, HttpServletRequest request) {
        List<Message> list = chatSessionService.selfList(fromId, toId, request.getSession());
        return new R(list);
    }

    /**
     * 退出登录
     *
     * @param id      用户ID
     * @param request 从Session中剔除
     * @return
     */
    @DeleteMapping("/{id}")
    public R logout(@PathVariable("id") String id, HttpServletRequest request) {
        if (id != null) {
            request.getSession().removeAttribute(id);
        }
        return new R();
    }
}
