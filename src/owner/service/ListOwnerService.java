package owner.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import owner.dao.OwnerDAO;
import owner.model.Owner;

public class ListOwnerService {
	private OwnerDAO ownerDao = new OwnerDAO();
	private int size = 5;

	public OwnerPage getOwnerPage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = ownerDao.selectCount(conn);
			List<Owner> comment = ownerDao.select(conn, (pageNum - 1) * size, size);
			return new OwnerPage(total, pageNum, size, comment);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
