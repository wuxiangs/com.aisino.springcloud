package com.aisino.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuxiang
 * @date 2021/7/4 4:42 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        /**
         * this.code = code;
         * this.message = message;
        */
        this(code,message,null);
    }
}
