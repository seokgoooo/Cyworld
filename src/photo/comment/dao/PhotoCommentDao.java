package photo.comment.dao;

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
import photo.model.PhotoComment;

public class PhotoCommentDao {

	// () 사진첩 번호와 같은 댓글을 가져오는 쿼리문
	public List<PhotoComment> allComment(int photoNum) {
		ResultSet rs = null;
		String query = "select * from comment where photoNum=?";
		List<PhotoComment> list = new ArrayList<PhotoComment>();
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			rs = pstmt.executeQuery();
			while (rs.next()) {
				PhotoComment pc = new PhotoComment();
				pc.setComment(rs.getString("comment"));
				pc.setCommentRegDate(rs.getDate("comment_regdate"));
				pc.setCommentModDate(rs.getDate("comment_moddate"));
				pc.setPhotoNum(rs.getInt("photoNum"));
				pc.setUserId(rs.getString("user_id"));

				list.add(pc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 댓글 등록
	public void insertComment(PhotoComment pc) {
		String query = "INSERT INTO `cyworld`.`photo_comment` "
				+ "(`comment`, `comment_regdate`, `comment_moddate`, `photo_num`, `user_id`) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setString(1, pc.getComment());
			pstmt.setTimestamp(2, toTimestamp(pc.getCommentRegDate()));
			pstmt.setTimestamp(3, toTimestamp(pc.getCommentModDate()));
			pstmt.setInt(4, pc.getPhotoNum());
			pstmt.setString(5, pc.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 댓글 삭제
	public void deleteComment(int comment_num) {
		String query = "delete from photo_comment where comment_num=?";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, comment_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 댓글 순서대로 가져오기
	public List<PhotoComment> selectAllComment() {
		String query = "select * from photo_comment order by comment_num desc";
		List<PhotoComment> list = new ArrayList<PhotoComment>();
		
		try(Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			while(rs.next()) {
				PhotoComment pc = new PhotoComment();
				pc.setComment(rs.getString("photo_comment"));
				pc.setCommentRegDate(rs.getDate("comment_regdate"));
				pc.setCommentRegDate(rs.getDate("comment_moddate"));
				pc.setPhotoNum(rs.getInt("photo_num"));
				pc.setUserId(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
