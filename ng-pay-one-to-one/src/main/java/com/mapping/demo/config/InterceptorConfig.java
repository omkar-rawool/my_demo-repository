package com.mapping.demo.config;

import com.mapping.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

        @Autowired
        private final MyInterceptor myInterceptor;

        public InterceptorConfig(MyInterceptor myInterceptor) {
                this.myInterceptor = myInterceptor;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(myInterceptor);
        }
}
