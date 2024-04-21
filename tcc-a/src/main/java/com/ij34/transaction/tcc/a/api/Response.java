package com.ij34.transaction.tcc.a.api;

import lombok.Data;

/**
 * @Author: ij34
 * @Date: 2024-04-20
 */
@Data
public class Response{
    private Object data;

    private int code;

    private String msg;

    // 成功响应的静态工厂方法
    public static Response success(Object data) {
        Response response = new Response();
        response.setData(data);
        response.setCode(0);
        response.setMsg("success");
        return response;
    }

    // 失败响应的静态工厂方法
    public static Response failure(int code) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg("fail");
        return response;
    }
    public static Response failure(int code,String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}
