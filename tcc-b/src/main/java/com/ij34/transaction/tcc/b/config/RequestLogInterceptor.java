//package com.ij34.transaction.tcc.b.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Slf4j
//public class RequestLogInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//
//        // 打印请求信息
////        log.info("------------- Request Start -------------");
//        log.info("请求 URI: {}", request.getRequestURI());
//        log.info("请求 Method: {}", request.getMethod());
//        // 等等其它请求信息
//
//        return true;
//    }
//
//}