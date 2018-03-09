package com.petgoes.api;

import com.petgoes.param.User;

import java.util.List;

public interface UserService {
	
	String sayHello(String userName);

	List<User> getUserList(User user);

}
