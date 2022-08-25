package photo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import photo.model.Photo;
import jdbc.JdbcUtil;
import photo.model.Photo;

public class PhotoDao {

	public Photo insert(Connection conn, Photo photo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"insert into photo (photo_title, photo_regdate, photo_moddate, user_id) values (?,?,?,?)");
			pstmt.setString(1, photo.getTitle());
			pstmt.setTimestamp(2, toTimestamp(photo.getRegDate()));
			pstmt.setTimestamp(3, toTimestamp(photo.getModDate()));
			pstmt.setString(4, "id");
			int insertedCount = pstmt.executeUpdate();
			// 업데이트는 늘 한번만 되니깐 insertedCount는 1

			if (insertedCount > 0) { // 1 이면 추가 성공
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from photo"); // 포토 칼럼의 맨 마지막 id 가져옴
				if (rs.next()) {
					Integer newNo = rs.getInt(1); // rs에 담아둔 id값의 첫번째 칼럼을 newNo에 담음
					return new Photo(newNo,
							photo.getTitle(),
							photo.getRegDate(),
							photo.getModDate(),
							photo.getUserId());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

}
