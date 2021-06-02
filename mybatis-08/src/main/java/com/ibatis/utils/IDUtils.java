package com.ibatis.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all")//抑制警告
public class IDUtils {
    public static String getId() {
        return UUID.randomUUID().toString();
//        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void test(){
        System.out.println(IDUtils.getId());
    }

}
