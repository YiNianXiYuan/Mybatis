package com.ibatis.dao;

import com.ibatis.pojo.Student;
import com.ibatis.pojo.Teacher;
import com.ibatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = mapper.getTeacher(1);
        System.out.println(teacher1);
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher2 = mapper.getTeacher2(1);
        System.out.println(teacher2);
        sqlSession.close();
    }
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    @Test
    public void getStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
