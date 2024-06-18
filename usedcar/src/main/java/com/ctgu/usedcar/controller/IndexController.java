package com.ctgu.usedcar.controller;


import com.ctgu.usedcar.dao.AdminDao;
import com.ctgu.usedcar.dao.UserDao;
import com.ctgu.usedcar.pojo.Admin;
import com.ctgu.usedcar.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    AdminDao adminDao;

    @Autowired
    UserDao userDao;

//    处理分页
    @GetMapping("/userlist")
    public String userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Map<String, Object> map){

        PageRequest request = PageRequest.of(page - 1, size);
        Page<User> userPage = userDao.findAll(request);
        map.put("userPage", userPage);
        map.put("currentPage", page);
        map.put("size", size);
        return "user/list";

    }

    @GetMapping("/goToQuery")
    public String userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "10") Integer size,
                           @RequestParam(value = "queryName", defaultValue = "") String name,
                           Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<User> userPage = userDao.findByNicknameContains(name, request);

        map.put("name", name);
        map.put("userPage", userPage);
        map.put("currentPage", page);
        map.put("size", size);
        return "user/querylist";

    }

    @PostMapping("/login")
    public String adminLogin(@RequestParam("username") String name,
                             @RequestParam("password") String pwd,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map,
                             HttpSession session){

        Admin admin = adminDao.findByAdminNameAndAdminPassword(name, pwd);
        if(admin != null){
//            map.put("username", name);
//            map.put("password", pwd);
//            用于拦截器验证
            session.setAttribute("username", name);
            return "redirect:/userlist";
        }
        map.put("msg", "用户名或密码错误，请重新输入");
        return "index";
    }

//    跳转至初始登录页面
    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }


}
