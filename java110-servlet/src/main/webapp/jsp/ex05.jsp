<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% // 스크립트릿: 자바 코드를 두는 태그 
int a;
%>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
a = 100;
int b = a++;
%>
<h1>표현식(Expression Element)</h1>
<pre>
- 실행 결과를 출력할 때 사용한다.
- 자바 코드:
      표현식 안에 작성한 코드가 출력문의 파라미터로 복사된다.
      out.print(표현식)
- 표현식(express)?
  어떤 결과를 리턴하는 코드이다.
</pre>
<p>100 + 200 = <% out.print(100 + 200); %></p>
<p>100 + 200 = <%= 100 + 200 %></p> <!-- out.print(100+200); -->
</body>
</html>