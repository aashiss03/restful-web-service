package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int userCount = 3;
	private static List<User> users = new ArrayList<User>();

	static {

		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Evans", new Date()));
		users.add(new User(1, "jack", new Date()));
	}

	public List<User> findAll() {

		return users;
	}

	

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);

		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}

		}
		return null;

	}

}
