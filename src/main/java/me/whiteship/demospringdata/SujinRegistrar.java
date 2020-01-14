package me.whiteship.demospringdata;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class SujinRegistrar implements ImportBeanDefinitionRegistrar{

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


        GenericBeanDefinition beanDefinition= new GenericBeanDefinition();
        beanDefinition.setBeanClass(Sujin.class);
        beanDefinition.getPropertyValues().add("name","Goood Job!!");

         registry.registerBeanDefinition("sujin",beanDefinition);
    }
}


