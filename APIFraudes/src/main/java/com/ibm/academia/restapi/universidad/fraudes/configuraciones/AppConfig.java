package com.ibm.academia.restapi.universidad.fraudes.configuraciones;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig
{
    @Bean("direccionRest")
    public RestTemplate registrarRestTemplate()
    {
        return new RestTemplate();
    }
}