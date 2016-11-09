package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		List<BoardVO> list = null;
		try (SqlSession session = MyBatisFactory.INSTANCE.factory.openSession();) {

			list = session.selectOne("org.zerock.dao.BoardMapper.list");
			System.out.println(list);

		}

		return list;
	}
}
