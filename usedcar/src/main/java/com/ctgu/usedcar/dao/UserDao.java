package com.ctgu.usedcar.dao;

import com.ctgu.usedcar.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, String > {

    Page<User> findByNicknameContains(String name, Pageable pageable);
}
