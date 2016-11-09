package org.zerock.test;

import static org.junit.Assert.fail;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	private SqlSessionFactory factory;
	
	@Before
	public void setup()throws Exception {
		System.out.println("------setup----");
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() {
		System.out.println(factory);
	}

}
