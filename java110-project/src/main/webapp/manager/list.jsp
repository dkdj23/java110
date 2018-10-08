<%@ page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='EUC-KR'>
<title>매니저 관리</title>
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
	<h1>매니저 목록(MVC)</h1>
	<p>
		<a href='add'>추가</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>직위</th>
			</tr>
		</thead>
		<tbody>
		
		<jsp:useBean id="list" 
		scope="request"
		type="java.util.List<bitcamp.java110.cms.domain.Manager>"
		class="java.util.ArrayList"/>
		<%
		  //List<Manager> list = (List<Manager>) request.getAttribute("list");
		  
		  for (Manager m : list) {
		      pageContext.setAttribute("m",m);
		%>
		    <tr>
                <td>${m.no}</td>
                <td><a href='detail?no=${m.no}'>${m.name}</a></td>
                <td>${m.email}</td>
                <td>${m.position}</td>
            </tr>
	    <%
	        }
		%>
		</tbody>
	</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>
