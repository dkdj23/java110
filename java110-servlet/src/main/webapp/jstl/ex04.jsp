<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:remove</h1>
<pre>
- 보관소에 저장된 값을 제거한다.
</pre>
<%
pageContext.setAttribute("name1","홍길동");
request.setAttribute("name1","임꺽정");
session.setAttribute("name1","유관순");
application.setAttribute("name1","김구");
%>

1: ${pageScope.name1 }<br>
2: ${requestScope.name1 }<br>
3: ${sessionScope.name1 }<br>
4: ${applicationScope.name1 }<br>

<hr>
<c:remove var="name1" scope="request"/>
1: ${pageScope.name1 }<br>
2: ${requestScope.name1 }<br>
3: ${sessionScope.name1 }<br>
4: ${applicationScope.name1 }<br>
</body>
</html>