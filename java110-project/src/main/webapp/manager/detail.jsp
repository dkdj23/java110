<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
#photo-image{
    height: 100px;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>암호</th>
				<th>전화</th>
				<th>직위</th>
				<th>사진</th>
			</tr>
		<tbody>
			<tr>
				<td>${manager.no}</td>
				<td>${manager.name}</td>
				<td>${manager.email}</td>
				<td>${manager.password}</td>
				<td>${manager.tel}</td>
				<td>${manager.position}</td>
				<c:choose>
				    <c:when test="${not empty manager.photo}">
						<td>
						    <img id='photo-image' src='/upload/${manager.photo}'>
						</td>
				    </c:when>
				    <c:otherwise>
						<td>
						    <img id='photo-image' src='/image/anonymous.png'>
						</td>
				    </c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>
	<button type='button' onclick='delete1()'>삭제</button>
	<script>
        function delete1() {
            location.href = 'delete?no=${manager.no}';
        }
    </script>
<jsp:include page="../footer.jsp"/>
</body>
</html>
