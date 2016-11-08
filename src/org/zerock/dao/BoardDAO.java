package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.BoardVO;

public enum BoardDAO {
	INSTANCE;

	public void create(BoardVO vo) throws Exception {

		String sql = "insert into tbl_board(title,content,writer) values(?,?,?)";

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getWriter());
				pstmt.executeUpdate();

			}
		}.execute();

	}

	public BoardVO read(Integer bno) throws Exception {

		String sql = "select * from tbl_board where bno = ?";
		List<BoardVO> resultArr = new ArrayList<>();
		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					BoardVO vo = new BoardVO();
					vo.setBno(rs.getInt("bno"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setWriter(rs.getString("writer"));

					resultArr.add(vo);

				}
			}
		}.execute();

		return resultArr.get(0);

	}

	public void update(BoardVO vo) throws Exception {
		String sql = "UPDATE tbl_board SET `content`=? WHERE `bno`=?";

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, vo.getContent());
				pstmt.setInt(2, vo.getBno());

				pstmt.executeUpdate();

			}
		}.execute();

	}

	public void delete(Integer bno) throws Exception {

		String sql = "delete from tbl_board where bno =?";
		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, bno);

				pstmt.executeUpdate();

			}
		}.execute();
	}

}
