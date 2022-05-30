package org.example.service.impl;

import org.example.service.Service;

/**
 * @author Administrator
 * 目标对象
 */
public class SuperStarZhouImpl implements Service {

    @Override
    public void sing() {
        System.out.println("我是周润发，我正在表演唱歌...");
    }

    @Override
    public String show(int age) {
        System.out.println("周润发的show..." + age);
        return "Zhou";
    }
}
