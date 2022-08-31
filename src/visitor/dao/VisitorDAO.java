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
import owner.model.Owner;
import visitor.model.Visitor;

public class VisitorDAO {

	public Visitor insert(Connection conn, Visitor visitor) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into visitor_content"
					+ "(content, content_regdate, content_moddate, user_num)" + "values (?, ?, ?, ?)");
			pstmt.setString(1, visitor.getContent());
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, visitor.getUser_num());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() from visitor_content");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Visitor(newNum, visitor.getUser_num(), visitor.getContent(),
							visitor.getContent_regdate(), visitor.getContent_moddate());
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
			rs = stmt.executeQuery("SELECT count(*) from visitor_content");
			if (rs.next()) {
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
			pstmt = conn.prepareStatement(
					"SELECT A.*, B.comment_num, B.comment, B.comment_regdate, B.comment_moddate FROM (SELECT B.*, A.name FROM users AS A INNER JOIN visitor_content AS B on A.num = B.user_num) AS A LEFT JOIN visitor_comment AS B on A.content_num = B.content_num ORDER BY content_num DESC limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Visitor> result = new ArrayList<Visitor>();
			while (rs.next()) {
				result.add(convertVisitor(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 새로 추가한부분
	public List<Owner> selectOwner(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("call fullcontent()");
			rs = pstmt.executeQuery();
			List<Owner> owner = new ArrayList<Owner>();
			while (rs.next()) {
				owner.add(convertOwner(rs));
			}
			return owner;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

//	public List<VisitorRequest> selectWriteVisitor(Connection conn, int startRow, int size) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement("SELECT B.*, A.name FROM users  AS A INNER JOIN visitor_content AS B on A.num = B.user_num desc limit ?, ?");
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, size);
//			rs = pstmt.executeQuery();
//			List<WriteVisitorRequest> result = new ArrayList<WriteVisitorRequest>();
//			while(rs.next()) {
//				result.add(convertWriteVisitor(rs));
//			}
//			return result;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}

	private Visitor convertVisitor(ResultSet rs) throws SQLException {
		return new Visitor(rs.getInt("content_num"), rs.getInt("user_num"), rs.getString("content"),
				rs.getString("content_regdate"), rs.getString("content_moddate"), rs.getString("name"),
				convertOwner(rs));
	}

	private Owner convertOwner(ResultSet rs) throws SQLException {
		return new Owner(rs.getInt("comment_num"), rs.getString("comment"), rs.getString("comment_regdate"),
				rs.getString("comment_moddate"), rs.getInt("content_num"), rs.getString("name"));
	}

//	private VisitorRequest convertWriteVisitor(ResultSet rs) throws SQLException {
//		return new VisitorRequest(new Writer(Integer.valueOf(rs.getString("user_num")), rs.getString("name")), convertVisitor(rs));
//	}

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