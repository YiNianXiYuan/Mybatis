package com.ibatis.dao;

import com.ibatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //查询用户通过id
    User queryUserByid(@Param("id") int id);
    //修改用户
    int updateUser(User user);
}
