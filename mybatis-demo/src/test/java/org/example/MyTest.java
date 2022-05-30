package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Student;
import org.example.proxy.ProxyFactory;
import org.example.service.Service;
import org.example.service.impl.SuperStarLiuImpl;
import org.example.service.impl.SuperStarZhouImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void testJdk(){
        ProxyFactory factory = new ProxyFactory(new SuperStarZhouImpl());
        Service agent = (Service) factory.getAgent();
        String s = agent.show(20);
        System.out.println(s);
        System.out.println(agent.getClass());
        Service service = new SuperStarLiuImpl();
        System.out.println(service.getClass());
    }

    @Test
    public void testGetAll() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        完成查询操作
        List<Student> list = sqlSession.selectList("wmf.getAll");
        list.forEach(student -> System.out.println(student));
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetById() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        按主键查询
        Student student = sqlSession.selectOne("wmf.getById", 1001);
        System.out.println(student);
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetByName() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        模糊查询
        Student student = sqlSession.selectOne("wmf.getByName", "张三");
        System.out.println(student);
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        调用方法
        int num = sqlSession.insert("wmf.insert", new Student("haha", "haha@126.com", 18));
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        调用方法
        int num = sqlSession.delete("wmf.delete", 1007);
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
//        使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        取出sqlSession的对象
        SqlSession sqlSession = factory.openSession();
//        调用方法
        int num = sqlSession.update("wmf.update", new Student(1006, "盾山", "dunshan@qq.com", 21));
        System.out.println(num);
//        切记：在所有增删改后必须手工提交事务！！
        sqlSession.commit();
//        关闭sqlSession
        sqlSession.close();
    }

}
