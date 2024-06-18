package com.ctgu.usedcar.controller;


import com.ctgu.usedcar.dao.GoodsDao;
import com.ctgu.usedcar.pojo.Goods;
import com.ctgu.usedcar.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;

    //    处理分页
    @GetMapping("/goodlist")
    public String goodList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Goods> goodsPage = goodsDao.findAll(request);
        map.put("goodsPage", goodsPage);
        map.put("currentPage", page);
        map.put("size", size);
        return "goods/list";
    }


    @RequestMapping("/putAway")
    public String putAway(@RequestParam("goodsnum") Integer goodsnum,
                                  Map<String, Object> map){
        Goods goods = goodsDao.getOne(goodsnum);
        goods.setState(1);
        goodsDao.save(goods);
        return "redirect:/goodlist";
    }

    @RequestMapping("/soldOut")
    public String soldOut(@RequestParam("goodsnum") Integer goodsnum,
                          Map<String, Object> map){
        Goods goods = goodsDao.getOne(goodsnum);
        goods.setState(2);
        goodsDao.save(goods);
        return "redirect:/goodlist";
    }
}
