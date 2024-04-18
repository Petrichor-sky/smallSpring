package com.petrichor.springframework.beans.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
