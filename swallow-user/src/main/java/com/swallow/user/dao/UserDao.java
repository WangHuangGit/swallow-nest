package com.swallow.user.dao;

import com.swallow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User的JpaRepository数据访问类
 * @author WangHan
 * @date 2018/12/25 16:41
 */

public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 通过名称模糊查询
     * @param name 姓名
     * @return List<User>
     * @author WangHan
     * @date 2018/12/25 16:50
     */
    List<User> findByNameLike(String name);

    /**
     * 通过hql查询
     * @param name 姓名(:name对应@Param里的name)
     * @return User
     * @author WangHan
     * @date 2018/12/25 16:54
     */
    @Query("from User u where u.name=:name")
    User findByHQL(@Param("name") String name);
}
