package com.ctgu.usedcar.dao;

import com.ctgu.usedcar.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminDao extends JpaRepository<Admin, Integer> {

    Admin findByAdminNameAndAdminPassword(String name, String pwd);

}
