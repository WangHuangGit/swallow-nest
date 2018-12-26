package com.swallow.user.comment;

/**
 * ResponseResult的工具类
 * @author WangHan
 * @date 2018/12/26 11:06
 */

public final class ResponseUtil {

    public static ResponseResult getInstance(boolean success, ResultCode resultCode, Object data){

        return new ResponseResult<>(success, resultCode.getCode(), resultCode.getMsg(), data);
    }
}
