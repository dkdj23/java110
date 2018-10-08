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
<h1>JSP 액션 태그 - jsp:useBean - 보관소에 객체가 없을 때</h1>
<pre>
- 보관소에 객체가 없으면 class 속성에 지정된 타입으로  객체를 만든다. 
  &lt;jsp:useBean
      scope="request"
      id="names1"
      class="java.tuil.ArrayList"/>
- 위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList names1 = (java.lang.String)pageContext.getAttribute("names1");
if (names1 == null){
    names1 = new java.util.ArrayList();
    pageContext.setAttribute("names1",names1);
} 
</pre>

<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
list1.add("안중근");

request.setAttribute("names1",list1);
%>

<jsp:useBean 
	scope="request" 
	id="names1" 
	class="java.util.ArrayList"/>
	
<p>names1.get(1) <%=names1.get(0)%>

<jsp:useBean 
    scope="request" 
    id="names2" 
    class="java.util.ArrayList"/>
<%--
위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.util.ArrayList names2 = (java.lang.String)request.getAttribute("names2");
if (names2 == null){
    names2 = new java.util.ArrayList();
    pageContext.setAttribute("names2",names2);
} 
--%>
<p>names2.size() <%=names2.size()%>
</body>
</html>