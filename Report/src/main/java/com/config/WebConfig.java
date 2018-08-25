package com.config;

import com.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
        .defaultContentType(MediaType.APPLICATION_JSON)
        .favorPathExtension(true);
    /*configurer.favorPathExtension(true).
        favorParameter(true).
        parameterName("mediaType").
        ignoreAcceptHeader(true).
        useJaf(false).
        defaultContentType(MediaType.APPLICATION_JSON).
        mediaType("xml", MediaType.APPLICATION_XML).
        mediaType("json", MediaType.APPLICATION_JSON);*/

  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    // LogInterceptor áp dụng cho mọi URL.
    registry.addInterceptor(new LogInterceptor());

    /*// Đường dẫn login cũ, không còn sử dụng nữa.
    // Sử dụng OldURLInterceptor để điều hướng tới một URL mới.
    registry.addInterceptor(new OldLoginInterceptor())//
        .addPathPatterns("/admin/oldLogin");


    // Interceptor này áp dụng cho các URL có dạng /admin/*
    // Loại đi trường hợp /admin/oldLogin
    registry.addInterceptor(new AdminInterceptor())//
        .addPathPatterns("/admin/*")//
        .excludePathPatterns("/admin/oldLogin");*/
  }

  @Bean
  public CustomAutowireConfigurer qualifierAutowireConfigurer() {
    CustomAutowireConfigurer customAutowireConfig = new CustomAutowireConfigurer();
    customAutowireConfig.setCustomQualifierTypes( Collections.singleton( Qualifier.class ));
    return customAutowireConfig;
  }
}
