package com.swallow.user.service;

import com.swallow.user.entity.User;

/**
 * User的逻辑处理接口
 * @author WangHan
 * @date 2018/12/26 11:24
 */
public interface UserService {

    /**
     * user保存
     * @param user 新增user实体
     * @author WangHan
     * @date 2018/12/26 11:28
     */
    void save(User user);

    /**
     * 获取用户电话
     * @param name 姓名
     * @return String
     * @author WangHan
     * @date 2018/12/26 11:29
     */
    String getUserPhone(String name);
}
