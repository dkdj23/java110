<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>강사 관리</title>
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
	<h1>강사 상세정보(MVC)</h1>
<jsp:include page="../header.jsp"/>
    <h1>학생 상세정보(MVC)</h1>
    <jsp:useBean id="teacher" 
    scope="request"
    class="bitcamp.java110.cms.domain.Teacher"/>    	
<%
//Teacher t = (Teacher)request.getAttribute("teacher");
if (teacher == null){
%>
    <p>해당 번호의 강사가 없습니다!</p>
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
				<th>시급</th>
				<th>강의과목</th>
			</tr>
		<tbody>
			<tr>
				<td><%=teacher.getNo()%></td>
				<td><%=teacher.getName()%></td>
				<td><%=teacher.getEmail()%></td>
				<td><%=teacher.getPassword()%></td>
				<td><%=teacher.getTel()%></td>
				<td><%=teacher.getPay()%></td>
				<td><%=teacher.getSubjects()%></td>
			</tr>
		</tbody>
	</table>
	<button type='button' onclick='delete1()'>삭제</button>
	<script>
        function delete1() {
            location.href = 'delete?no=<%=teacher.getNo()%>';
        }
    </script>
<jsp:include page="../footer.jsp"/>
</body>
</html>
<%
}
%>
