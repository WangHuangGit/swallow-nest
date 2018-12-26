package com.swallow.user.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Restful API返回统一响应体
 * @author WangHan
 * @date 2018/12/26 10:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {

    private Boolean success;
    private Integer code;
    private String msg;
    private T data;
}
