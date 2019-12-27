package com.kpoim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kpoim")
public class MyWebMvcConfigurer implements WebMvcConfigurer {

  @Autowired
  private StringToRoleConverter stringToRoleConverter;

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	registry.viewResolver(viewResolver);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	String[] paths = {"/static/**"};
	String[] locations = {"/static/"};
	registry.addResourceHandler(paths).addResourceLocations(locations);
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
	registry.addConverter(stringToRoleConverter);
  }
}
