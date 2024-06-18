package com.ctgu.usedcar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testQuery(){
//        System.out.println(userDao.findAll());
//        userDao.findById("123");
//        System.out.println(userDao.findByNicknameContains("敖"));

    }

}