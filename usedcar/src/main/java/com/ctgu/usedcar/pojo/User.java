package com.ctgu.usedcar.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "telenum")
    private String telenum;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "headicon")
    private String headicon;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "dwells")
    private String dwells;

    @Column(name = "college")
    private String college;

    @Column(name = "major")
    private String major;

    @Column(name = "grade")
    private String grade;

    @Column(name = "balance")
    private String balance;

    @Column(name = "dormitory")
    private String dormitory;

    @Column(name = "info_integrity")
    private Integer infoIntegrity;
}
