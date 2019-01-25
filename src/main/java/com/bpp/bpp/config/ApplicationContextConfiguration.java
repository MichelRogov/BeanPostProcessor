package com.bpp.bpp.config;

import com.bpp.bpp.model.User;
import com.bpp.bpp.processor.BeansMappingAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfiguration {

    @Bean
    public BeansMappingAnnotationBeanPostProcessor beansMappingAnnotationBeanPostProcessor() {
        return new BeansMappingAnnotationBeanPostProcessor();
    }

    @Bean
    public User user() {
        return new User();
    }
}
