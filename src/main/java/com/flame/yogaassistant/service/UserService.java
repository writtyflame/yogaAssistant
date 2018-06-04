package com.flame.yogaassistant.service;

import com.flame.yogaassistant.domain.User;

import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 17:49 2018/5/30
 * @Modified By:
 */
public interface UserService {
    /**
     * 根据用户的id 获取用户的信息
     *
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 添加一个用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据userId 删除用户信息
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Integer userId);
}
