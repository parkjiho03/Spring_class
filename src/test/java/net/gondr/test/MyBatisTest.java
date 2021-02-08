package net.gondr.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class MyBatisTest {
	@Autowired
	private SqlSessionFactory factory;
	
	@Test
	public void testFactory() {
		System.out.println(factory);
	}
	
	@Test
	public void testSession() {
		try {
			SqlSession s = factory.openSession();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
