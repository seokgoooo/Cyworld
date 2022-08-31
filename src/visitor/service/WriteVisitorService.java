package visitor.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

import visitor.service.WriteVisitorRequest;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import visitor.dao.VisitorDAO;
import visitor.model.Visitor;

public class WriteVisitorService {
	private VisitorDAO visitorDao = new VisitorDAO();

	public Integer write(WriteVisitorRequest req) {
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
	
	private Visitor toVisitor(WriteVisitorRequest req) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeFormat = localDateTime.format(
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")
	        );
		return new Visitor(null, req.getWriter().getUser_num(), req.getContent(), localDateTimeFormat, localDateTimeFormat);
	}
	
}
