package org.zerock.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.zerock.domain.BoardVO;

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
	public void testList() throws Exception {
		SqlSession session = factory.openSession();
		try {
			List<BoardVO> list = session.selectList("org.zerock.dao.BoardMapper.list", 0);
			System.out.println(list);

		} finally {
			session.close();
		}

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
