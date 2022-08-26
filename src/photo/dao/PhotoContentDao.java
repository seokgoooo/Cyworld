package photo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import photo.model.PhotoContent;

public class PhotoContentDao {
	public PhotoContent insert(Connection conn, PhotoContent content) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into photo_content content values ?");
			pstmt.setString(1, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public PhotoContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from photo_content where photo_num=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			PhotoContent content = null;

			if (rs.next()) {
				content = new PhotoContent(rs.getInt("contentNum"), rs.getString("content"), rs.getString("contentImg"),
						rs.getInt("photoNum"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}