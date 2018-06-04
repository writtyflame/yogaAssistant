package com.flame.yogaassistant.mapper;

import com.flame.yogaassistant.domain.Area;
import com.flame.yogaassistant.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 查询用户集合信息
     *
     * @return
     */
    List<User> queryUser();

    /**
     * 查询单个用户信息
     *
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 插入一个用户信息
     *
     * @param user 用户
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 逻辑删除用户信息
     *
     * @param id
     * @return
     */
    int deleteUserById(Integer id);
}
