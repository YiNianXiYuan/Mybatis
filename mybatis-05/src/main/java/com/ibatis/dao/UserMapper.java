package com.ibatis.dao;

import com.ibatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
//@Param("")基本数据类型加上，引用数据类型不需要加。在SQL语句中引用的就是@Param的属性名
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);
}
