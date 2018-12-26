package com.swallow.gateway.exception;

import com.swallow.gateway.comment.ResponseResult;
import com.swallow.gateway.comment.ResponseUtil;
import com.swallow.gateway.comment.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 全局异常处理
 * @author WangHan
 * @date 2018/12/26 14:57
 */

@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ZuulRuntimeException.class)
    public ResponseResult redisExceptionHandler(ZuulRuntimeException e) {

        log.error(e.getMessage(), e);
        return ResponseUtil.getInstance(false, ResultCode.SYSTEM_INNER_ERROR, new HashMap<>(0));
    }
}
