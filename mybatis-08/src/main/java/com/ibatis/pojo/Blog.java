package com.ibatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private String  id;
    private String title;
    private String author;
    private Date createTime;//属性和字段名不一样
    private int views;
}
