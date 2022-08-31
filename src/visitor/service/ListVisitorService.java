package visitor.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import jdbc.connection.ConnectionProvider;
import owner.model.Owner;
import visitor.dao.VisitorDAO;
import visitor.model.Visitor;

public class ListVisitorService {
	private VisitorDAO visitorDao = new VisitorDAO();
	private int size = 5;
	
	public VisitorPage getVisitorPage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = visitorDao.selectCount(conn);
			List<Visitor> content = visitorDao.select(
					conn, (pageNum - 1) * size, size);
			System.out.println(new Gson().toJson(content));
//			List<String> name = visitorDao.selectName(conn); // 새로추가한부분
			return new VisitorPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
