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
<h1>JSTL - c:redirect</h1>
<pre>
- redirect 응답하기
</pre>

<c:if test="${param.search == 'naver'}">
    <c:redirect url="http://naver.com"/>
</c:if>
<c:if test="${param.search == 'daum'}">
    <c:redirect url="http://daum.net"/>
</c:if>
<c:if test="${param.search == 'google'}">
    <c:redirect url="http://google.com"/>
</c:if>

<p>search 라는 이름으로 검색 엔진을 지정하세요!!</p>
</body>
</html>