package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.CostumerMapper;
import org.example.mapper.OrdersMapper;
import org.example.mapper.UsersMapper;
import org.example.pojo.Costumer;
import org.example.pojo.Orders;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class MyReferenceTest {

    SqlSession sqlSession;
    CostumerMapper costumerMapper;
    OrdersMapper ordersMapper;
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
        costumerMapper = sqlSession.getMapper(CostumerMapper.class);
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    }

    @After
    public void closeSqlSession(){
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetCostumerById(){
        Costumer costumer = costumerMapper.getById(3);
        System.out.println(costumer);
    }

    @Test
    public void testGetOrdersById(){
        Orders orders = ordersMapper.getById(11);
        System.out.println(orders);
    }
}
