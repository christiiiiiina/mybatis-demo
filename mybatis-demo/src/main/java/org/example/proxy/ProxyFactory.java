package org.example.proxy;

import org.example.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class ProxyFactory {
    /**
     * 类中的成员变量设计为接口,目标对象
     */
    private Service target;

    /**
     * 传入目标对象
     * @param target 目标对象
     */
    public ProxyFactory(Service target){
        this.target = target;
    }

    /**
     * 返回动态代理对象
     * @return 动态代理对象
     */
    public Object getAgent(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("预订时间...");
                System.out.println("预订场地...");
                Object obj = method.invoke(target, args);
                System.out.println("结算费用...");
                return obj;
            }
        });
    }
}
