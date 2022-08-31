package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("gender"),
						toDate(rs.getTimestamp("regdate")),
						rs.getString("img_path"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void insert(Connection conn, Member user) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO users (`id`, `pw`, `name`, `gender`, `regdate`) VALUES(?, ?, ?, ?, ?)")) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getGender());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member user) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET pw = ?, img_path = ? WHERE id = ?")) {
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getImg_path());
			pstmt.setString(3, user.getId());
			pstmt.executeUpdate();
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
}