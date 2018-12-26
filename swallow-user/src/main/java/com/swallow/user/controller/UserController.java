package com.swallow.user.controller;

import com.swallow.user.comment.ResponseResult;
import com.swallow.user.comment.ResponseUtil;
import com.swallow.user.comment.ResultCode;
import com.swallow.user.entity.User;
import com.swallow.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;

/**
 * user的api接口
 * @author WangHan
 * @date 2018/12/25 15:12
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @SuppressWarnings("all")
    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    public ResponseResult addUser(@Valid @RequestBody User user) {

        userService.save(user);
        return ResponseUtil.getInstance(true, ResultCode.SUCCESS, new HashMap<>(1));
    }

    @GetMapping(value = "/phone")
    public ResponseResult getUserPhone(@NotBlank String name) {

        String phone = userService.getUserPhone(name);
        HashMap<String, String> map = new HashMap<>(1);
        map.put("phone", phone);
        return ResponseUtil.getInstance(true, ResultCode.SUCCESS, map);

    }
}
