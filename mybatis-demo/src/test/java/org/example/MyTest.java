package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    SqlSession sqlSession;

    @Before
    public void openSqlSession() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        sqlSession = factory.openSession();
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

}
