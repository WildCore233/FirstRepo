package org.example;

import org.example.interpector.ApartParamCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApartInterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private ApartParamCheck apartParamCheck;
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apartParamCheck).addPathPatterns("/Apart");
    }
}
