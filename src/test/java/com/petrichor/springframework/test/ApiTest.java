package com.petrichor.springframework.test;

import com.petrichor.springframework.BeanDefinition;
import com.petrichor.springframework.BeanFactory;
import com.petrichor.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.petrichor.springframework.test.bean.UserService;
import org.junit.Test;


public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //第一次获取bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

        //第二次获取bean
        UserService userService_singleton = (UserService)beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }
}
