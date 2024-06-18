package com.ctgu.usedcar.controller;


import com.ctgu.usedcar.dao.UserDao;
import com.ctgu.usedcar.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/deleteByTel")
    public String delUserByTel(@RequestParam("telNum") String telNum){
        userDao.deleteById(telNum);
        return "redirect:/userlist";
    }

    @RequestMapping("/updateUserBytel")
    public String updateUserBytel(@RequestParam("telNum") String telNum,
                                  Map<String, Object> map){
        Optional<User> list = userDao.findById(telNum);
        User user = list.get();
        map.put("user", user);
        return "user/index";
    }

    @RequestMapping("/saveUpdate")
    public String saveUpdate(@RequestParam("password") String password,
                             @RequestParam("nickname") String nickname,
                             @RequestParam("balance") String balance,
                             @RequestParam("infoIntegrity") String infoIntegrity,
                             @RequestParam("telenum") String telNum){
        User user = userDao.getOne(telNum);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setBalance(balance);
        user.setInfoIntegrity(Integer.parseInt(infoIntegrity));
        userDao.save(user);
        return "redirect:/userlist";
    }


}
