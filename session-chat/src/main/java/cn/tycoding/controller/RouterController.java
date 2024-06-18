package cn.tycoding.controller;

import cn.tycoding.entity.ChatUser;
import cn.tycoding.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 路由接口控制器
 *
 */
@Slf4j
@Controller
public class RouterController {

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping("/wechat")
    public String index() {
        return "login";
    }

    /**
     * 登录接口
     *
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public R login(@RequestBody ChatUser user, HttpServletRequest request) {
        Enumeration<String> ids = request.getSession().getAttributeNames();
        while (ids.hasMoreElements()) {
            String id = ids.nextElement();
            if (request.getSession().getAttribute(id) instanceof ChatUser) {
                if (((ChatUser) request.getSession().getAttribute(id)).getName().equals(user.getName())) {
                    return new R(500, "该用户名已存在");
                }
            }
        }
        request.getSession().setAttribute(user.getId().toString(), user);
        log.info("session >> {}", request.getSession().getAttribute(user.getId().toString()));
        return new R();
    }

    /**
     * 首页入口
     *
     * @return
     */
    @GetMapping("/{id}/chat")
    public String index(@PathVariable("id") Long id, HttpServletRequest request) {
        Object user = request.getSession().getAttribute(id.toString());
        if (user == null) {
            return "redirect:/";
        }
        return "index";
    }
}
