package com.petrichor.springframework.beans.factory.support;

import com.petrichor.springframework.BeanDefinition;
import com.petrichor.springframework.beans.BeansException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {  //todo 有参构造的入参对象怎么处理
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }


}
