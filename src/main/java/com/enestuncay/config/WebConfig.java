package com.enestuncay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.enestuncay")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/login/**")
                .addResourceLocations("/WEB-INF/login/");

        registry.addResourceHandler("/index/**")
                .addResourceLocations("/WEB-INF/index/");

        registry.addResourceHandler("/custom/**")
                .addResourceLocations("/WEB-INF/custom/");

        /*

        //Front end files can be located directly under WEB-INF (like WEB-INF/css/main.css) by example of below code

        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/css/");

        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/WEB-INF/fonts/");

        registry.addResourceHandler("/images/**")
                .addResourceLocations("/WEB-INF/images/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/WEB-INF/js/");

        registry.addResourceHandler("/vendor/**")
                .addResourceLocations("/WEB-INF/vendor/");
        */
    }



}