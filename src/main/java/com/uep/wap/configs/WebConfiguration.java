package com.uep.wap.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//You need to declare a MessageResource Spring Bean, so that
// the Spring automatically load the
// contents of the validation.properties file to memory.
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{

    @Bean
    public MessageSource messageSource() {
        System.out.println("messageSource");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Load file: validation.properties
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
