package com.petrichor.springframework.beans.factory.support;

import com.petrichor.springframework.beans.BeansException;
import com.petrichor.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
