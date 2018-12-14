package com.mamadimi.dao;

import com.mamadimi.models.User;

public interface UserDAO {
	
	public void save(User user);
	public void update(User user);
	
	public User getUserByEmail(String email);
	public User getUserById(long id);
	

}
