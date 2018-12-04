package com.ylt.springdata.controller;

import com.ylt.springdata.entity.User;
import com.ylt.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author yuliantao
 * @create 2018-11-30 10:41
 * @description 功能描述
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        //getone在2.0版本中已经失效了，坑啊
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }

    @GetMapping("/user")
    public User insertUser(User user)
    {
        User save=userRepository.save(user);
        return save;
    }
}
