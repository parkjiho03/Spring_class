package net.gondr.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class UserDAOTest {
	@Autowired
	private UserDAO dao;
	
	//@Test
	public void testDao() {
		System.out.println(dao);
	}
	
	@Test
	public void inserTest() {
		UserVO user = new UserVO();
		user.setUserid("parkjh");
		user.setPassword("1234");
		user.setUsername("박지호");
		
		dao.insertUser(user);
	}

}
