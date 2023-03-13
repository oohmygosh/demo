package com.vipicu.demo.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * WEB 初始化相关配置
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@ControllerAdvice
@Configuration
public class BootConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedOriginPatterns("*")
                .allowedHeaders("*");
    }
}
