<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>학생 관리</title>
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
	<h1>학생 상세정보(MVC)</h1>
        <jsp:useBean id="student" 
        scope="request"
        class="bitcamp.java110.cms.domain.Student"/>	
<%
//Student s = (Student)request.getAttribute("student");
if (student == null){
%>
    <p>해당 번호의 학생이 없습니다!</p>
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
				<th>최종학력</th>
				<th>전화</th>
				<th>재직여부</th>
			</tr>
		<tbody>
			<tr>
				<td><%=student.getNo()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getPassword()%></td>
				<td><%=student.getSchool()%></td>
				<td><%=student.getTel()%></td>
				<td><%=student.isWorking()%></td>
			</tr>
		</tbody>
	</table>
	<button type='button' onclick='delete1()'>삭제</button>
	<script>
        function delete1() {
            location.href = 'delete?no=<%=student.getNo()%>';
        }
    </script>
<jsp:include page="../footer.jsp"/>
</body>
</html>
<%
}
%>
