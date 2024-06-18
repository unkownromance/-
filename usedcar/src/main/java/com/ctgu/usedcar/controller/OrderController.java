package com.ctgu.usedcar.controller;


import com.ctgu.usedcar.dao.GoodsDao;
import com.ctgu.usedcar.dao.OrderDao;
import com.ctgu.usedcar.pojo.Goods;
import com.ctgu.usedcar.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @Autowired
    GoodsDao goodsDao;

    //    处理分页
    @GetMapping("/orderlist")
    public String orderList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Order> orderPage = orderDao.findAll(request);
        map.put("orderPage", orderPage);
        map.put("currentPage", page);
        map.put("size", size);
        return "order/list";
    }


    @GetMapping("/delOrder")
    public String delOrder(@RequestParam("orderId") Integer orderid){
        orderDao.deleteById(orderid);
        return "redirect:/orderlist";
    }


    @GetMapping("/whatBuyAndSold")
    public String buyAndSold(@RequestParam("name") String name,
                             Map<String, Object> map){

        List<Order> buyerList = orderDao.findByBuyerAndState(name, 4);
        List<Order> sellerList = orderDao.findBySellerAndState(name, 4);

        List<Goods> buyList = new ArrayList<Goods>();
        List<Goods> sellList = new ArrayList<Goods>();

        for (Order order : buyerList) {
            Goods goods = goodsDao.getOne(order.getGoodnum());
            buyList.add(goods);
        }
        for (Order order : sellerList) {
            Goods goods = goodsDao.getOne(order.getGoodnum());
            sellList.add(goods);
        }

        map.put("buyList", buyList);
        map.put("sellList", sellList);
        map.put("name", name);

        return "order/index";
    }
}
