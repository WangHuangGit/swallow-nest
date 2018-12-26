package com.swallow.api.user.fallback;

import com.swallow.api.comment.ResponseResult;
import com.swallow.api.comment.ResponseUtil;
import com.swallow.api.comment.ResultCode;
import com.swallow.api.user.service.UserService;
import com.swallow.api.user.vo.UserVo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 熔断器，返回特定的异常
 * @author WangHan
 * @date 2018/12/26 11:55
 */

@Component
public class UserServiceFallbackImpl implements UserService {

    @Override
    public ResponseResult addUser(UserVo user) {
        return ResponseUtil.getInstance(false, ResultCode.INTERFACE_INNER_INVOKE_ERROR, new HashMap<>(1));
    }
}
