package org.zerock.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	private SqlSessionFactory factory;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void test() {
		System.out.println(factory);
	}

	@Test
	public void testGetTime() throws Exception {
		SqlSession session = factory.openSession();
		try {
			String now = session.selectOne("org.zerock.dao.TimeMapper.getTime");
			System.out.println(now);

		} finally {
			session.close();
		}

	}

}
