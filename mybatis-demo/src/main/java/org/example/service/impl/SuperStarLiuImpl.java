package org.example.service.impl;

import org.example.service.Service;

/**
 * @author Administrator
 * 目标对象：刘德华，实现业务接口中的功能，进程唱歌表演
 */
public class SuperStarLiuImpl implements Service {

    @Override
    public void sing() {
        System.out.println("我是刘德华，我正在表演唱歌...");
    }

    @Override
    public String show(int age) {
        System.out.println("刘德华的show..." + age);
        return "Liu";
    }
}
