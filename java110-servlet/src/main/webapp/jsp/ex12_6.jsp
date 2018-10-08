<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션태그</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean - 사용자 정의 객체 생성 테스트</h1>
<jsp:useBean 
    scope="request" 
    id="m1" 
    class="bitcamp.java110.Member" />
    
<p>
번호: <%=m1.getNo()%><br>
이름: <%=m1.getName()%><br>
이메일: <%=m1.getEmail()%><br>
전화: <%=m1.getTel()%><br>
<p>
</body>
</html>