package visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import visitor.model.Visitor;

public class VisitorDAO {
	
	public Visitor insert(Connection conn, Visitor visitor) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into content"
					+ "(user_id, content, content_regdate, content_moddate)"
					+ "values (?, ?, ?, ?)");
			pstmt.setString(1, visitor.getUser_id());
			pstmt.setString(2, visitor.getContent());
			pstmt.setTimestamp(3, toTimestamp(visitor.getContent_regdate()));
			pstmt.setTimestamp(4, toTimestamp(visitor.getContent_moddate()));
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() from content");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Visitor(newNum, 
							visitor.getUser_id(), 
							visitor.getContent(), 
							visitor.getContent_regdate(), 
							visitor.getContent_moddate());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT count(*) from content");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Visitor> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * from content order by content_num desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Visitor> result = new ArrayList<Visitor>();
			while(rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Visitor convertArticle(ResultSet rs) throws SQLException {
		return new Visitor(
		rs.getInt("content_num"),
		rs.getString("user_id"),
		rs.getString("content"),
		toDate(rs.getTimestamp("content_regdate")),
		toDate(rs.getTimestamp("content_moddate")));
	}


	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
}

//	private ContentDAO() { }

//	private static ContentDAO instance = new ContentDAO();
//	
//	private static ContentDAO getInstance() {
//		return instance;
//	}

//	public List<VisitorVO> selectContent(Connection conn, VisitorVO visitor) throws SQLException {
//		PreparedStatement pstmt = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		String query = "SELECT * FROM cyworld.content";
//		List<VisitorVO> list = new ArrayList<VisitorVO>();
//		try {
//			pstmt = conn.prepareStatement(query);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				VisitorVO cVo = new VisitorVO();
//				cVo.setContent_num(rs.getInt("content_num"));
//				cVo.setUser_id(rs.getString("user_id"));
//				cVo.setContent(rs.getString("content"));
//				cVo.setContent_regdate(toDate(rs.getTimestamp("content_regdate")));
//				cVo.setContent_moddate(rs.getDate("content_moddate"));
//				list.add(cVo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	