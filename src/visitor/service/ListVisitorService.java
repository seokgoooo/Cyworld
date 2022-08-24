package visitor.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import visitor.dao.VisitorDAO;
import visitor.model.Visitor;

public class ListVisitorService {
	private VisitorDAO visitorDao = new VisitorDAO();
	private int size = 10;
	
	public VisitorPage getVisitorPage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = visitorDao.selectCount(conn);
			List<Visitor> content = visitorDao.select(
					conn, (pageNum - 1) * size, size);
			return new VisitorPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
