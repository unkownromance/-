package com.ctgu.usedcar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void testQuery(){

//        System.out.println(orderDao.findAll());
        System.out.println(orderDao.findByBuyerAndState("root", 4));


    }

}