package com.bpp.bpp.processor;

import com.bpp.bpp.processor.annotation.BeansMapping;
import com.bpp.bpp.shared.SharedBeans;
import com.bpp.bpp.shared.SharedBeansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeansMappingAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> requiredBeans = new HashMap<>();
    private Map<String, SharedBeans> beansMap = new HashMap<>();

    @Autowired
    SharedBeansMapper sharedBeansMapper;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> clazz = bean.getClass();

        if(!isMethodAnnotated(clazz.getDeclaredMethods())) {
            return bean;
        }

        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class<?> cInterface : interfaces) {
            if(SharedBeans.class.isAssignableFrom(cInterface)) {
                requiredBeans.put(beanName, clazz);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Class clazz = requiredBeans.get(beanName);
        if(clazz == null) {
            return bean;
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method: declaredMethods) {
            BeansMapping annotation = method.getAnnotation(BeansMapping.class);
            if (annotation != null) {
                beansMap.put(annotation.key(), (SharedBeans) bean);
            }
        }
        sharedBeansMapper.setSharedBeansMap(beansMap);

        return bean;
    }

    private boolean isMethodAnnotated(Method[] declaredMethods) {
        return Arrays.stream(declaredMethods).anyMatch(m -> m.getAnnotation(BeansMapping.class) != null);
    }
}
