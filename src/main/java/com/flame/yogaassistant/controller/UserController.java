package com.flame.yogaassistant.controller;

import com.flame.yogaassistant.domain.Area;
import com.flame.yogaassistant.domain.User;
import com.flame.yogaassistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 17:46 2018/5/30
 * @Modified By:
 */
@RestController
@RequestMapping("/superadmin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listuser")
    public Map<String, Object> listUser(){
        Map<String, Object> modelMap = new HashMap<>();
        List<User> list = userService.getUserList();
        modelMap.put("userList", list);
        return modelMap;
    }

    @GetMapping("/getuser")
    public Map<String, Object> getUserByUserId(Integer userId){
        Map<String, Object> modelMap = new HashMap<>();
        User user = userService.getUserByUserId(userId);
        modelMap.put("user", user);
        return modelMap;
    }

    @PostMapping("/adduser")
    public Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", userService.addUser(user));
        return modelMap;
    }


    @PostMapping("/updateuser")
    public Map<String, Object> modifyArea(@RequestBody User user){
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", userService.updateUser(user));

        return modelMap;
    }

    @GetMapping("/deluser")
    public Map<String, Object> deleteUser(Integer userId){
        System.out.println(userId);
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", userService.deleteUser(userId));
        return modelMap;
    }
}
