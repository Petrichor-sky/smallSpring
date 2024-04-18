package com.petrichor.springframework.test;

import com.petrichor.springframework.beans.factory.config.BeanDefinition;
import com.petrichor.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.petrichor.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
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

    @Test
    public void test_BeanFactory4() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }

    @Test
    public void test_BeanFactory4_1() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o = enhancer.create(new Class[]{String.class}, new String[]{"凡哥"});
        System.out.println(o);
    }

}
