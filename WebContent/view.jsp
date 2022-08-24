<%@page import="visitor.model.Visitor"%>
<%@page import="visitor.dao.VisitorDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.connection.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try(Connection conn = ConnectionProvider.getConnection()) {
	out.println("연결 성공");
} catch(SQLException e) {
	out.println("커넥션 연결 실패함" + e.getMessage());
	application.log("연결실패", e); 
}

%>

</body>
</html>