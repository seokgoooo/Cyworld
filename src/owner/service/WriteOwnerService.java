package owner.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import owner.dao.OwnerDAO;
import owner.model.Owner;

public class WriteOwnerService {
	private OwnerDAO ownerDao = new OwnerDAO();

	public Integer write(WriteOwnerRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Owner visitor = toOwner(req);
			Owner savedOwner = ownerDao.insert(conn, visitor);
			if (savedOwner == null) {
				throw new RuntimeException("fail to insert owner");
			}

			conn.commit();

			return savedOwner.getComment_num();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Owner toOwner(WriteOwnerRequest req) {
		Date now = new Date();
		return new Owner(null, req.getComment(), now, now, req.getContent_num());
	}
}
