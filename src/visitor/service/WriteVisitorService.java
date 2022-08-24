package visitor.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import visitor.service.WriteRequest;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import visitor.dao.VisitorDAO;
import visitor.model.Visitor;

public class WriteVisitorService {
	private VisitorDAO visitorDao = new VisitorDAO();

	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Visitor visitor = toVisitor(req);
			Visitor savedVisitor = visitorDao.insert(conn, visitor);
			if(savedVisitor == null) {
				throw new RuntimeException("fail to insert visitor");
			}
			
			conn.commit();
			
			return savedVisitor.getContent_num();
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	private Visitor toVisitor(WriteRequest req) {
		Date now = new Date();
		return new Visitor(null, req.getUser_id(), req.getContent(), now, now);
	}
	
}
