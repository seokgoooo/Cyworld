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

import jdbc.connection.ConnectionProvider;
import photo.model.Photo;

public class PhotoDao {
	private PhotoDao() {

	}

	private static PhotoDao instance = new PhotoDao();

	public static PhotoDao getInstance() {
		return instance;
	}

	// 사진 추가
	public void insertPhoto(Photo photo, Integer num) {
		String sql = "insert into photo (photo_title, photo_regdate, photo_moddate, url, user_num, content) values (?,?,?,?,?,?)";// 사진을
																																	// 등록하는
																																	// 쿼리문
		try (Connection conn = ConnectionProvider.getConnection(); // 데이터베이스와 통신
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// 변수에 담아놓은 쿼리문을 데이터베이스에 넣어줌.
			pstmt.setString(1, photo.getTitle());// 1번째로 받는 데이터는 사진첩제목.
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis())); // 1번째로 받는 데이터는 사진첩내용.
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, photo.getUrl());// 1번째로 받는 데이터는 사진url.
			pstmt.setInt(5, num);// fk
			pstmt.setString(6, photo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Photo> selectPhoto() {
		String sql = "select*from photo order by photo_num desc";
		List<Photo> list = new ArrayList<Photo>();
		try (Connection conn = ConnectionProvider.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Photo photo = new Photo();
				photo.setNumber(rs.getInt("photo_num"));// 사진번호
				photo.setTitle(rs.getString("photo_title"));// 사진제목
				photo.setContent(rs.getString("content"));// 내용
				toDate(rs.getTimestamp("photo_regdate"));
				toDate(rs.getTimestamp("photo_moddate"));
				photo.setUrl(rs.getString("url"));// 사진 url
				photo.setUser_num(rs.getInt("user_num"));// 유저아이디
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());

	}

	public void deletePhoto(Integer photo_num) {
		String sql = "delete from photo where photo_num = ?";// 사진첩에 작성한 게시물을 삭제하는 쿼리문
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, photo_num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePhoto(Photo photo) {
		String sql = "update photo set photo_title =?, content=?, url=?, photo_moddate=?, where photo_num=?";// 사진첩의 내용을
																												// 수정하는
																												// 쿼리문
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, photo.getTitle());
			pstmt.setString(2, photo.getContent());
			pstmt.setString(3, photo.getUrl());
			pstmt.setTimestamp(4, new Timestamp(photo.getModDate().getTime()));
			pstmt.setInt(5, photo.getNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
			rs.close();
			stmt.close();

		}
	}

	// 페이지 설정
	public List<Photo> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from photo " + "order by photo_num desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Photo> result = new ArrayList<Photo>();
			while (rs.next()) {
				result.add(new Photo(rs.getInt("photo_num"), rs.getString("photo_title"),
						toDate(rs.getTimestamp("photo_regdate")), toDate(rs.getTimestamp("photo_moddate")),
						rs.getString("url"), rs.getString("content"), rs.getInt("user_num")));
			}
			return result;

		} finally {
			pstmt.close();
			rs.close();
		}
	}

	// 업데이트 할 메소드
	public Photo selectProductPhotoNum(Integer photo_num) {
		String sql = "select* from photo where photo_num=?";// 사진첩번호와 같은 사진첩의 데이터를 가져오는 쿼리문
		Photo photo = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, photo_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				photo = new Photo();
				photo.setNumber(rs.getInt("photo_num"));
				photo.setTitle(rs.getString("photo_title"));
				toDate(rs.getTimestamp("photo_regdate"));
				toDate(rs.getTimestamp("photo_moddate"));
				photo.setUrl(rs.getString("url"));
				photo.setUser_num(rs.getInt("user_num"));
				photo.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return photo;
	}

}
