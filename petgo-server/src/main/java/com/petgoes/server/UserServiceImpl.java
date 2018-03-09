package com.petgoes.server;

import com.petgoes.api.UserService;
import com.petgoes.mapper.user.UserMapper;
import com.petgoes.param.User;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MotanService
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getUserList(User user) {
		List<User> list = userMapper.query(user);
		return list;
	}


	@Override
	public String sayHello(String user) {
		System.out.println("We get in the service");
		return "Hello "+user;
	}

}
