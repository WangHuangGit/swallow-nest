package com.swallow.user.service.impl;

import com.swallow.user.dao.UserDao;
import com.swallow.user.entity.User;
import com.swallow.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User的逻辑实现类
 * @author WangHan
 * @date 2018/12/26 11:25
 */

@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("all")
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public String getUserPhone(String name) {

        User user = userDao.findByHQL(name);

        if (user != null && !user.getPhone().isEmpty()) {
            return user.getPhone();
        }else {
            return "";
        }
    }
}
