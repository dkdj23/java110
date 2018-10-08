<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>학생 관리</title>
<link rel='stylesheet' href='/css/common.css'>
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
	<h1>학생 목록(MVC)</h1>
	<p>
		<a href='add'>추가</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>최종학력</th>
				<th>재직여부</th>
			</tr>
		</thead>
		<tbody>
		  <c:forEach items="${list}" var="s">
		    <tr>
                <td>${s.no}</td>
                <td><a href='detail?no=${s.no}'>${s.name}</a></td>
                <td>${s.email}</td>
                <td>${s.school}</td>
                <td>${s.working}</td>
            </tr>
           </c:forEach>
		</tbody>
	</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
