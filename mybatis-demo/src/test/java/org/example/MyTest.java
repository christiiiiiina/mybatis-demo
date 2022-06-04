package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UsersMapper;
import org.example.pojo.Student;
import org.example.pojo.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyTest {

    SqlSession sqlSession;
    UsersMapper uMapper;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void openSqlSession() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        sqlSession = factory.openSession();
//        取出动态代理的对象，完成接口中方法的调用，实则是调用xml文件中相应的标签功能
        uMapper = sqlSession.getMapper(UsersMapper.class);
    }

    @After
    public void closeSqlSession(){
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetAll() throws IOException {
//        完成查询操作
        List<Student> list = sqlSession.selectList("wmf.getAll");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void testGetById() throws IOException {
//        按主键查询
        Student student = sqlSession.selectOne("wmf.getById", 1001);
        System.out.println(student);
    }

    @Test
    public void testGetByName() throws IOException {
//        模糊查询
        Student student = sqlSession.selectOne("wmf.getByName", "张三");
        System.out.println(student);
    }

    @Test
    public void testInsert() throws IOException {
//        调用方法
        int num = sqlSession.insert("wmf.insert", new Student("haha", "haha@126.com", 18));
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

    @Test
    public void testDelete() throws IOException {
//        调用方法
        int num = sqlSession.delete("wmf.delete", 1008);
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

    @Test
    public void testUpdate() throws IOException {
//        调用方法
        int num = sqlSession.update("wmf.update", new Student(1006, "盾山", "dunshan@qq.com", 21));
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

    @Test
    public void testUsersGetAll(){
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        List<Users> list = uMapper.getAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testUsersGetUsersById(){
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        Users users = uMapper.getUsersById(1);
        System.out.println(users);
    }

    @Test
    public void testUsersGetByUsername(){
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        List<Users> list = uMapper.getUserByUsername("小明");
        list.forEach(System.out::println);
    }

    @Test
    public void testUsersInsert() throws ParseException {
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        Users users = new Users("张飞", sf.parse("2000-01-01"), "1", "河北");
        int sum = uMapper.insert(users);
        System.out.println(sum);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

    @Test
    public void testUsersUpdate() throws ParseException {
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        Users users = new Users(8,"张飞", sf.parse("2000-01-01"), "1", "长坂坡");
        int sum = uMapper.update(users);
        System.out.println(sum);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

    @Test
    public void testUsersDelete() throws ParseException {
//        就是在调用接口中的方法，mybatis框架已经为我们把功能代理出来了
        int sum = uMapper.delete(8);
        System.out.println(sum);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
    }

}
