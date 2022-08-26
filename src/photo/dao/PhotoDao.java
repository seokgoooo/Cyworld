package photo.dao;

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
import jdbc.connection.ConnectionProvider;
import photo.model.Photo;

public class PhotoDao {
	// 게시글 개수를 구하기위한 selectCount 메소드
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from photo");

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

	}

	public List<Photo> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from photo order by photo_num desc limit ?,?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();

			List<Photo> result = new ArrayList<Photo>();
			while (rs.next()) {
				result.add(convertPhoto(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Photo convertPhoto(ResultSet rs) throws SQLException {
		return new Photo(rs.getString("photo_title"), toDate(rs.getTimestamp("photo_regDate")),
				toDate(rs.getTimestamp("photo_modDate")), rs.getString("user_Id"), rs.getInt("readcount"));

	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public Photo selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from photo where photo_num=?");
			rs = pstmt.executeQuery();

			Photo photo = null;
			if (rs.next()) {
				photo = convertPhoto(rs);
			}
			
			return photo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update photo set readcount = readcount +1" + "where photo_num =?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}

}
