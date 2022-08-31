package owner.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import onwer.dao.OwnerDAO;
import owner.model.Owner;
import owner.service.WriteOwnerRequest;

public class WriteOwnerService {
	private OwnerDAO ownerDao = new OwnerDAO();

	public Integer write(WriteOwnerRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Owner owner = toOwner(req);
			System.out.println("인서트 시작");
			Owner savedOwner = ownerDao.insert(conn, owner);
			if(savedOwner == null) {
				throw new RuntimeException("fail to insert owner");
			}
			System.out.println("인서트 끝");
			conn.commit();
			
			return savedOwner.getComment_num();
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
	
	private Owner toOwner(WriteOwnerRequest req) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeFormat = localDateTime.format(
	            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")
	        );
		return new Owner(null, req.getComment(), localDateTimeFormat, localDateTimeFormat, req.getContent_num(), req.getWriter().getName());
	}
}
