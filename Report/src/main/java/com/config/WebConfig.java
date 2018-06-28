package com.config;

import com.viewResolver.ExcelViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
  {
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

  /*
   * Configure ContentNegotiatingViewResolver
   */
  @Bean
  public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager)
  {
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setContentNegotiationManager(manager);

    // Define all possible view resolvers
    List<ViewResolver> resolvers = new ArrayList<>();

    resolvers.add(excelViewResolver());

    resolver.setViewResolvers(resolvers);
    return resolver;
  }

  /*
   * Configure View resolver to provide XLS output using Apache POI library to
   * generate XLS output for an object content
   */
  @Bean
  public ViewResolver excelViewResolver()
  {
    return new ExcelViewResolver();
  }

}
