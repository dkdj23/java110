<%@page import="java.io.PrintWriter"%>
<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

  <!DOCTYPE html>
  <html>
  <head>
  <meta charset='EUC-KR'>
  <title>실행 오류</title>
  <link rel='stylesheet' href='/css/common.css'>
  <style>
	  table,th,td
	  border: 1px solid gray;
	  }
	  table{
	  border-collapse: collapse; 
	  }
  </style>
  </head>
  <body>
	  <jsp:include page="header.jsp"/>
	  <%
	  Exception e = (Exception) request.getAttribute("error");
	  String message = (String) request.getAttribute("message");
	  %>
	  <h1>JSP:<%=message%></h1>
	  <p><%=e.getMessage()%></p>
	  <pre><%e.printStackTrace(new PrintWriter(out));%></pre>
	  <jsp:include page="footer.jsp"/>
  </body>
  </html>

