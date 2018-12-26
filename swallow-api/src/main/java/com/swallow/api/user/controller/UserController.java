package com.swallow.api.user.controller;

import com.swallow.api.comment.ResponseResult;
import com.swallow.api.user.service.UserService;
import com.swallow.api.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * User模块对外暴露的接口
 * @author WangHan
 * @date 2018/12/26 9:56
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @SuppressWarnings("all")
    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    public ResponseResult addUser(@Valid @RequestBody UserVo userVo) {

        return userService.addUser(userVo);
    }

}
