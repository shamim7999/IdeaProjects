package com.config.without.xml;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.config.without.xml")
public class JavaConfig {
    @Bean
    public Person getPerson() {
        return new Person();
    }

    @Bean
    public Person getPerson2() {
        return new Person(); /// ---> Different HashCodes
    }
}
