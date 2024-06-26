package com.petrichor.springframework.beans.factory.support;

import com.petrichor.springframework.beans.factory.config.BeanDefinition;
import com.petrichor.springframework.beans.factory.BeanFactory;
import com.petrichor.springframework.beans.BeansException;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }


    /**
     * 这个抽象类相当于定义了模板,真正的逻辑看其继承的实现
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    public <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object bean = getSingleton(name);
        if(bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
