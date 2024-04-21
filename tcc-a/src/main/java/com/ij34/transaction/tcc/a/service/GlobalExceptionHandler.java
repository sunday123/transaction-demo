package com.ij34.transaction.tcc.a.service;

import com.ij34.transaction.tcc.a.api.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ... 其他异常处理方法 ...

    @ExceptionHandler
    public ResponseEntity<Response> handleIllegalArgumentException(Exception ex) {
        return ResponseEntity.ok(Response.failure(-2,ex.getMessage()));
    }
}