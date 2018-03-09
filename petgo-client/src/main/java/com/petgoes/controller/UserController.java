package com.petgoes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petgoes.api.UserService;
import com.petgoes.param.User;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;

@RestController
@RequestMapping("/user")
public class UserController {
    @MotanReferer
    private UserService userService;

    @RequestMapping("/hi")
    public String home() {
        System.out.println("+++++++++++++get in client++++++++++++++");
        String result = userService == null ? "service is null" : "good,we get it";
        System.out.println(result);
        result = userService.sayHello("World");
        return result;
    }
    @RequestMapping("/getList")
    public List<User> getUserList() {
    	User user = new User();
    	List<User> users =  userService.getUserList(user);
    	return users;
    }

}
