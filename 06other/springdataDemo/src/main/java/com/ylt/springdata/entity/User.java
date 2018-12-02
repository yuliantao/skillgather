package com.ylt.springdata.entity;

import javax.persistence.*;

/**
 * @author yuliantao
 * @create 2018-11-30 10:18
 * @description 功能描述
 */
@Entity //标注是一个数据表映射的bean
@Table(name = "tbl_user")//指定对应表,如果省略则对应表名和类名相同（小写）
public class User {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增列
    private Integer id;
    @Column(name = "lastName",length = 50)//定义对应的列名，省略则和字段名相同
    private String lastName;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
