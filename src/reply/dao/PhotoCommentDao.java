package reply.dao;

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
import reply.model.PhotoComment;

public class PhotoCommentDao {
	private PhotoCommentDao() {

	}

	private static PhotoCommentDao instance = new PhotoCommentDao();

	public static PhotoCommentDao getInstance() {
		return instance;
	}

	public List<PhotoComment> selectAllReply(int photo_num) {
		String sql = " select * from reply where photo_num=?"; // 사진첩과 번호와 같은댓글을 가져오는 쿼리
		ResultSet rs = null;
		List<PhotoComment> list = new ArrayList<PhotoComment>(); // 생성

		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, photo_num); // 1번쨰로 받는 데이터는 댓글번호
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PhotoComment reply = new PhotoComment();

				reply.setComment_num(rs.getInt("comment_num"));
				reply.setComment(rs.getString("comment"));
				toDate(rs.getTimestamp("comment_regdate"));
				toDate(rs.getTimestamp("comment_moddate"));
				reply.setUser_num(rs.getInt("user_num"));
				reply.setPhoto_num(rs.getInt("photo_num"));

				list.add(reply);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());

	}

	public void insertReply(PhotoComment pc) {
		String sql = "insert into photo_comment(photo_num, user_num, comment) values(?,?,?)"; // 댓글등록쿼리
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, pc.getComment_num());
			pstmt.setTimestamp(2, new Timestamp(pc.getComment_regDate().getTime()));
			pstmt.setTimestamp(3, new Timestamp(pc.getComment_modDate().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<PhotoComment> allReply() {
		String sql = "select * from photo_comment order by commetn_num desc";
		List<PhotoComment> list = new ArrayList<PhotoComment>();

		try (Connection conn = ConnectionProvider.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				PhotoComment pc = new PhotoComment();
				pc.setComment_num(rs.getInt("comment_num"));
				pc.setComment(rs.getString("comment"));
				toDate(rs.getTimestamp("comment_regdate"));
				toDate(rs.getTimestamp("comment_moddate"));
				pc.setPhoto_num(rs.getInt("photo_num"));
				pc.setUser_num(rs.getInt("user_num"));

				list.add(pc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteReply(int comment_num) {
		String sql = "delete from photo_comment where comment_num=?";// 댓글삭제쿼리
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, comment_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
