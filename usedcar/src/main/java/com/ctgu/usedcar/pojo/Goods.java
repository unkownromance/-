package com.ctgu.usedcar.pojo;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_num")
    private Integer goodNum;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "summary_classifyname")
    private String summaryClassifyname;
    @Column(name = "detail_classifyname")
    private String detailClassifyname;
    @Column(name = "pic1")
    private String pic1;
    @Column(name = "pic2")
    private String pic2;
    @Column(name = "pic3")
    private String pic3;
    @Column(name = "state")
    private Integer state;
    @Column(name = "owner")
    private String owner;
    @Column(name = "star_count")
    private Integer starCount;
    @Column(name = "pur_comment")
    private String purComment;
}
