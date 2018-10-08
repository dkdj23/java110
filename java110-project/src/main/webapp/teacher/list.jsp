<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>강사 관리</title>
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
	<h1>강사 목록(MVC)</h1>
	<p>
		<a href='add'>추가</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>시급</th>
				<th>강의과목</th>
			</tr>
		</thead>
		<tbody>
        <jsp:useBean id="list" 
        scope="request"
        type="java.util.List<bitcamp.java110.cms.domain.Teacher>"
        class="java.util.ArrayList"/>   		
		<%
		  //List<Teacher> list = (List<Teacher>) request.getAttribute("list");
		  
		  for (Teacher t : list) {
		      pageContext.setAttribute("t",t);
		%>
		    <tr>
                <td>${t.no}</td>
                <td><a href='detail?no=${t.no}'>${t.name}</a></td>
                <td>${t.email}</td>
                <td>${t.pay}</td>
                <td>${t.subjects}</td>
	    <%
	        }
		%>
		</tbody>
	</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
