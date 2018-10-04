<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>매니저 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
	border: 1px solid gray;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
	<h1>매니저 상세정보(MVC)</h1>
<%
Manager m = (Manager)request.getAttribute("manager");
if (m == null){
%>
    <p>해당 번호의 매니저가 없습니다!</p>
<%
} else {
%>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>암호</th>
				<th>전화</th>
				<th>직위</th>
			</tr>
		<tbody>
			<tr>
				<td><%=m.getNo()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getPassword()%></td>
				<td><%=m.getTel()%></td>
				<td><%=m.getPosition()%></td>
			</tr>
		</tbody>
	</table>
	<button type='button' onclick='delete1()'>삭제</button>
	<script>
        function delete1() {
            location.href = 'delete?no=<%=m.getNo()%>';
        }
    </script>
<jsp:include page="../footer.jsp"/>
</body>
</html>
<%
}
%>
