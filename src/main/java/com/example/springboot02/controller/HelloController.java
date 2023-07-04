package com.example.springboot02.controller;

import com.example.springboot02.mapper.UserMapper;
import com.example.springboot02.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/getUser")
    public List<User> user(){
        return userMapper.find();
    }

    @GetMapping("/inputUser")
    public int inputUser(User user){
        return userMapper.insert(user);
    }

    @GetMapping("/map")
    public Map<String, Object> map(){
        Map<String, Object> m =new HashMap<>();
        User user =new User(1,"wdd","qq22212");
        m.put("用户信息",user);
        m.put("其他信息","hahah");
        return m;
    }
}
