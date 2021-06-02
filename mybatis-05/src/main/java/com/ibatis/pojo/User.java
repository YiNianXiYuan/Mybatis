package com.ibatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//实体类
//@Alias("hello")
@Data//生成所有的get、set、toString方法等
@AllArgsConstructor//所有有参构造
@NoArgsConstructor//无参构造
public class User {
    private int id;
    private String name;
    private String pwd;
}
