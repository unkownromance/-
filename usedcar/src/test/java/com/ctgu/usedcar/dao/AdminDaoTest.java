package com.ctgu.usedcar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {

    @Autowired
    AdminDao adminDao;

    @Test
    public void testQuery(){
        System.out.println(adminDao.findAll());
        System.out.println(adminDao.findByAdminNameAndAdminPassword("admin0", "admin"));
    }

}