package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//커넥션을 따로 뺴두어 개발,유지,보수 등이 용이함.
public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:cyworld");
	}
}
