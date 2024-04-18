package com.petrichor.springframework.beans.factory.support;

import com.petrichor.springframework.beans.BeansException;
import com.petrichor.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {

            // 1. 判断是否有参数构造器
            if(null != ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                //  默认无参构造器
                return clazz.getDeclaredConstructor().newInstance();
            }

        }catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e){
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
