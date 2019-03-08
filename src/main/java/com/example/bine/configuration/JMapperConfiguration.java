package com.example.bine.configuration;

import com.example.bine.customer.CustomerDBO;
import com.example.bine.customer.CustomerDTO;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.cache.JMapperCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMapperConfiguration {

    @Bean
    public JMapper<CustomerDTO, CustomerDBO> customerDBO2DTOMapper(){
        JMapper<CustomerDTO,CustomerDBO> mapper = (JMapper<CustomerDTO,CustomerDBO>)JMapperCache.getMapper(CustomerDTO.class,CustomerDBO.class);
        return mapper;

    }

    @Bean
    public JMapper<CustomerDBO, CustomerDTO> customerDTO2DBOMapper(){
        JMapper<CustomerDBO,CustomerDTO> mapper = (JMapper<CustomerDBO,CustomerDTO>)JMapperCache.getMapper(CustomerDBO.class,CustomerDTO.class);
        return mapper;
    }

}
