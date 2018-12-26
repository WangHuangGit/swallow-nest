package com.swallow.api.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Restful API返回统一响应体
 * @author WangHan
 * @date 2018/12/26 10:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

}
