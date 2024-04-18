package com.petrichor.springframework.beans.factory.support;

import com.petrichor.springframework.BeanDefinition;
import com.petrichor.springframework.BeanFactory;
import com.petrichor.springframework.beans.BeansException;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 这个抽象类相当于定义了模板,真正的逻辑看其继承的实现
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
