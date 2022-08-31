package onwer.dao;

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

public class OwnerDAO {

	public Owner insert(Connection conn, Owner owner) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into visitor_comment (comment, comment_regdate, comment_moddate, content_num, name) values (?, ?, ?, ?, ?)");
			pstmt.setString(1, owner.getComment());
			pstmt.setString(2, owner.getComment_regdate());
			pstmt.setString(3, owner.getComment_moddate());
			pstmt.setInt(4, owner.getContent_num());
			pstmt.setString(5, owner.getName());
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() from visitor_comment");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Owner(newNum, 
							owner.getComment(), 
							owner.getComment_regdate(), 
							owner.getComment_moddate(), 
							owner.getContent_num(),
							owner.getName());
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
			rs = stmt.executeQuery("SELECT count(*) from visitor_comment");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
//	public List<Owner> select(Connection conn, int startRow, int size) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement("SELECT A.*, B.comment_num, B.comment FROM (SELECT B.*, A.name FROM users AS A INNER JOIN visitor_content AS B on A.num = B.user_num) AS A LEFT JOIN visitor_comment AS B on A.content_num = B.content_num ORDER BY content_num DESC limit ?, ?");
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, size);
//			rs = pstmt.executeQuery();
//			List<Owner> result = new ArrayList<Owner>();
//			while(rs.next()) {
//				result.add(convertOwner(rs));
//			}
//			return result;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}
	
	public List<Visitor> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT A.*, B.comment_num, B.comment FROM (SELECT B.*, A.name FROM users AS A INNER JOIN visitor_content AS B on A.num = B.user_num) AS A LEFT JOIN visitor_comment AS B on A.content_num = B.content_num ORDER BY content_num DESC limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Visitor> result = new ArrayList<Visitor>();
			while(rs.next()) {
				result.add(convertVisitor(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Visitor convertVisitor(ResultSet rs) throws SQLException {
		return new Visitor(
		rs.getInt("content_num"),
		rs.getInt("user_num"),
		rs.getString("content"),
		rs.getString("content_regdate"),
		rs.getString("content_moddate"),
		rs.getString("name"),
		convertOwner(rs));
	}
	
	
	
	private Owner convertOwner(ResultSet rs) throws SQLException {
		return new Owner(
		rs.getInt("comment_num"),
		rs.getString("comment"),
		rs.getString("comment_regdate"),
		rs.getString("comment_moddate"),
		rs.getInt("content_num"),
		rs.getString("name"));
	}


	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
}

