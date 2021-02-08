package net.gondr.dao;

import net.gondr.domain.UserVO;

public interface UserDAO {
	public void insertUser(UserVO user);
	
	public UserVO selectUser(String userid);
}
