package com.swallow.api.user.service;

import com.swallow.api.comment.ResponseResult;
import com.swallow.api.user.fallback.UserServiceFallbackImpl;
import com.swallow.api.user.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * User模块的FeignClient用于调用swallow-user系统
 * @author WangHan
 * @date 2018/12/26 9:58
 */

@Service
@FeignClient(value = "swallow-user", fallback = UserServiceFallbackImpl.class)
public interface UserService {


    /**
     * 新增user调用swallow-user服务
     * @param user 实体
     * @return ResponseResult
     * @author WangHan
     * @date 2018/12/26 11:53
     */
    @PostMapping(value = "/user")
    ResponseResult addUser(@RequestBody UserVo user);
}
