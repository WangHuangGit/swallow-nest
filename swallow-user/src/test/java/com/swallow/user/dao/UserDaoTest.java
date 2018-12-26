package com.swallow.user.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceTest测试类
 * @author WangHan
 * @date 2018/12/25 17:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        Assert.assertEquals("13811110000", userDao.findByNameLike("王晗").get(0).getPhone());
    }

}