package com.ibatis.dao;

import com.ibatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //分页查询
    List<User> getUserByLimit(Map<String, Integer> map);
    //分页2
    List<User> getUserByRowBounds();
    List<User> getUserLike(String Value);

    //查询所有用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

//    Map<String, Object> getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //万能map
    int addUser(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    int updateUser(Map<String, Object> map);

    //删除一个用户
    int deleteUser(int id);
}
