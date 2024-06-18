package com.ctgu.usedcar.dao;

import com.ctgu.usedcar.pojo.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods, Integer> {
}
