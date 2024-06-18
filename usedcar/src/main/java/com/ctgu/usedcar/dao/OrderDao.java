package com.ctgu.usedcar.dao;

import com.ctgu.usedcar.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findByBuyerAndState(String buyerName, int state);

    List<Order> findBySellerAndState(String sellerName, int state);
}
