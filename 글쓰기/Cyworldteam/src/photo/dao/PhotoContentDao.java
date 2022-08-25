package photo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
