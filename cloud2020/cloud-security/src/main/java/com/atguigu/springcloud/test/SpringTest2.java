package com.atguigu.springcloud.test;

import com.atguigu.springcloud.test.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fuchaochao on 16/8/12.
 */
public class SpringTest2 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:appcontext-*.xml");
        HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
        System.out.println("14.Bean working, message = " + obj.getMessage());
        //((ClassPathXmlApplicationContext)context).refresh();
        ((ClassPathXmlApplicationContext)context).close();

    }
}