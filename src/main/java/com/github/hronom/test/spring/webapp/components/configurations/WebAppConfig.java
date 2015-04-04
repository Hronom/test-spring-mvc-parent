package com.github.hronom.test.spring.webapp.components.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({
    "com.github.hronom.test.spring.webapp.components.services",
    "com.github.hronom.test.spring.webapp.components.controllers",
    "com.github.hronom.test.spring.webapp.components.filters"
})
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}