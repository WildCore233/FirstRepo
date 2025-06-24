package org.example;

import lombok.Data;

@Data
public class result <T>{
    private Integer code;
    private String msg;
    private T data;
    private static <T> result<T> build(T data){
        result <T> res = new result<>();
        res.setData(data);
        return res;
    }
    public static <T> result<T> build(T body,resultEnum resultEnum){
        result<T> res = build(body);
        res.setCode(resultEnum.getCode());
        res.setMsg(resultEnum.getMessage());
        return res;
    }

public static <T> result<T> success(T data){return build(data,resultEnum.SUCCESS);}
public static <T> result<T> success(){return result.success(null);}
public static <T> result<T>fail(){return build(null,resultEnum.FAIL);}

}

