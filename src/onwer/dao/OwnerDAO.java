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

public class OwnerDAO {

	public Owner insert(Connection conn, Owner owner) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into comment (comment_num, comment, comment_regdate, comment_moddate) values (?, ?, ?, ?)");
			pstmt.setString(1, owner.getComment());
			pstmt.setTimestamp(2, toTimestamp(owner.getComment_regdate()));
			pstmt.setTimestamp(3, toTimestamp(owner.getComment_moddate()));
			pstmt.setInt(4, owner.getContent_num());
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() from comment");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Owner(newNum, 
							owner.getComment(), 
							owner.getComment_regdate(), 
							owner.getComment_moddate(), 
							owner.getContent_num());
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
			rs = stmt.executeQuery("SELECT count(*) from comment");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Owner> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * from comment order by comment_num desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Owner> result = new ArrayList<Owner>();
			while(rs.next()) {
				result.add(convertOwner(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Owner convertOwner(ResultSet rs) throws SQLException {
		return new Owner(
		rs.getInt("comment_num"),
		rs.getString("comment"),
		toDate(rs.getTimestamp("comment_regdate")),
		toDate(rs.getTimestamp("comment_moddate")),
		rs.getInt("content_num"));
	}


	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
}

