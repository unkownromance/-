package com.ctgu.usedcar.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderinfo")
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderid;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;

    @Column(name = "goodnum")
    private Integer goodnum;

    @Column(name = "price")
    private String price;

    @Column(name = "seller")
    private String seller;

    @Column(name = "state")
    private  Integer state;

    @Column(name = "pic")
    private  String pic;

}
