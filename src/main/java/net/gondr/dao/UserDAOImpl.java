package net.gondr.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.gondr.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	// 공장에서 찍어낸 세션을 여기에 의존성 주입해준다.
	@Autowired
	private SqlSession session;
	// const - 가비지 컬렉팅
	private static final String ns = "net.gondr.mappers.UserMapper";
	
	@Override
	public void insertUser(UserVO user) {
		session.insert(ns + ".insertUser", user);
	}
	
	@Override
	public UserVO selectUser(String userid) {
		return session.selectOne(ns + ".selectUser", userid);
	}
}
