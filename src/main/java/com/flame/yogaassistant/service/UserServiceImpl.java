package com.flame.yogaassistant.service;

import com.flame.yogaassistant.Utils.EncryptUtils;
import com.flame.yogaassistant.Utils.TimeUtils;
import com.flame.yogaassistant.domain.User;
import com.flame.yogaassistant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 17:53 2018/5/30
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.queryUser();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user) {
        if(user.getUserName() != null && !"".equals(user.getUserName())){
            // 设置插入信息时间
            user.setCreateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
            user.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
            //set userpassword
            try {
                user.setUserPassword(EncryptUtils.EncoderByMd5(user.getUserPassword()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                throw new RuntimeException("用户密码设置失败！" + e.getMessage());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new RuntimeException("用户密码设置失败！" + e.getMessage());
            }
            try {
                // 插入用户信息
                int effectedNum = userMapper.insertUser(user);

                if(effectedNum > 0){
                    return true;
                }else {
                    // @Transactional 默认只会回滚 RuntimeException 类型的异常
                    throw new RuntimeException("插入用户信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入用户信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("插入用户信息失败！");
        }
    }

    @Override
    public boolean updateUser(User user) {
        if(user.getUserId() != null && user.getUserId() > 0){
            // 修改最后一次修改时间
            user.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));

            if(!StringUtils.isEmpty(user.getUserPassword())){
                //set userpassword
                try {
                    user.setUserPassword(EncryptUtils.EncoderByMd5(user.getUserPassword()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    throw new RuntimeException("用户密码设置失败！" + e.getMessage());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    throw new RuntimeException("用户密码设置失败！" + e.getMessage());
                }
            }
            try {
                // 更新用户信息
                int effectedNum = userMapper.updateUser(user);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("修改用户信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改用户信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("修改用户信息失败！");
        }
    }

    @Override
    public boolean deleteUser(Integer userId) {
        if(userId > 0){
            try {
                // 删除用户信息
                int effectedNum = userMapper.deleteUserById(userId);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除用户信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除用户信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除用户信息失败！");
        }
    }
}
