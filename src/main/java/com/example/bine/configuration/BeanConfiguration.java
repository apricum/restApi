package com.example.bine.configuration;

import com.example.bine.aspects.MethodTimeLoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

    @Bean
    public MethodTimeLoggingAspect timer(){
        return new MethodTimeLoggingAspect();
    }
}
