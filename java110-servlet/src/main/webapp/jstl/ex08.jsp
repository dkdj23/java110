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
<h1>JSTL - c:forTokens</h1>
<pre>
- 반복문을 만든다.
</pre>

<h2>CVS(comma-separated value) 문자열</h2>
<%
pageContext.setAttribute("names1", "a,b,c,d,e,f,g");
%>

<ul>
   <c:forTokens items="${pageScope.names1}" var="n" delims=",">
        <li>${n}</li>
   </c:forTokens>
</ul>

<h2>Query String 문자열</h2>
<%
pageContext.setAttribute("qs", "name=홍길동&age=2&tel=1111-2222");
%>

<ul>
   <c:forTokens items="${qs}" var="n" delims="&">
        <li>${n}</li>
   </c:forTokens>
</ul>


</body>
</html>