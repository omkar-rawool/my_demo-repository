//package com.mapping.demo.filter;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//
//@Log4j2
//@Component
//public class SimpleFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        log.info("########################"+servletRequest.getAttribute("token"));
//        log.info("########################"+servletRequest.getLocalPort());
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
