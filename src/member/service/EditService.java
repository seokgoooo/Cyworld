package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.LoginFailException;
import auth.service.User;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class EditService {
	private MemberDao memberDao = new MemberDao();

	public void edit(EditRequest editReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Member member = memberDao.selectById(conn, editReq.getId());

			if (member == null) {
				JdbcUtil.rollback(conn);
				throw new MemberNotFoundException();
			}

			memberDao.update(conn,
					new Member(
							editReq.getId(), 
							editReq.getImg_path(),
							editReq.getTitle(),
							editReq.getProfile(),
							editReq.getMenu()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public User updateAuthUser(String id) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			
			return new User(
					member.getNum(), 
					member.getId(),
					member.getName(),
					member.getGender(),
					member.getRegdate(), 
					member.getImg_path(),
					member.getTitle(), 
					member.getProfile(), 
					member.getMenu(), 
					member.getPw());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}