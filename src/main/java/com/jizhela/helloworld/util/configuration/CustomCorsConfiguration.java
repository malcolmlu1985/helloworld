package com.jizhela.helloworld.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomCorsConfiguration {
	
	  @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	             registry.addMapping("/api/**").allowedOrigins("http://localhost:8081");
	             //表示只要请求是来自http://localhost:8081/api/*这个请求链接下面的所有请求，比如http://localhost:8081/api/get?name=t
	             //都可以对本工程【http://localhost:8080】下的所有文件进行跨域访问
	         }
	    };
	  }
}
