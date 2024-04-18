package com.petrichor.springframework;

import com.petrichor.springframework.beans.BeansException;


public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
