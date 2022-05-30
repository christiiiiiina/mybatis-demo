package org.example;

import org.example.proxy.ProxyFactory;
import org.example.service.Service;
import org.example.service.impl.SuperStarLiuImpl;
import org.example.service.impl.SuperStarZhouImpl;
import org.junit.Test;

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

}
