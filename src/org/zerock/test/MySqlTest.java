package org.zerock.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

public class MySqlTest {

	
	BoardVO vo;
	
	BoardDAO dao;
	@Test
	public void test() throws Exception {
		vo = new BoardVO(); 

	
		vo.setContent("엄준호");
		vo.setBno(8);
		
		dao.INSTANCE.delete(9);
		
	
	}

	@Test
	   public void testConnection()throws Exception{
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection(
	            "jdbc:mysql://192.168.0.129:3306/bit88?useSSL=false","makemoney","makemoney");
	      
	      System.out.println(con);
	      
	      con.close();
	   }
}
