package owner.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import onwer.dao.OwnerDAO;
import visitor.model.Visitor;
import visitor.service.VisitorPage;

public class ListOwnerService {
	private OwnerDAO ownerDao = new OwnerDAO();
	private int size = 5;
	
	public VisitorPage getOwnerPage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = ownerDao.selectCount(conn);
			List<Visitor> comment = ownerDao.select(
					conn, (pageNum - 1) * size, size);
			return new VisitorPage(total, pageNum, size, comment);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
