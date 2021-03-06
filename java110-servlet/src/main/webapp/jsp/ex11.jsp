<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSP 빌트인 객체</h1>
<pre>
- JSP 페이지에서 사용할 수 있는 자바 객체이다.
- JSP 페이지로 서블릿 클래스를 만들 떄 _jspService() 메서드 안에 생성되는 객체이다.
- 빌트인 객체
  request:HttpServletRequest   - _jspService() 의 파라미터
  response:HttpServletResponse - _jspService() 의 파라미터
  pageContext:pageContext      - _jspService() 의 로컬변수
  session:HttpSession          - _jspService() 의 로컬변수
  application:ServletContext   - _jspService() 의 로컬변수
  config:ServletConfig         - _jspService() 의 로컬변수
  out:JspWriter                - _jspService() 의 로컬변수
  page:Object                  - _jspService() 의 로컬변수
     - 현재 서블릿 객체를 가리킨다. 즉 this 이다.
  exception:Throwable          - _jspService() 의 로컬변수
     - JSP 페이지의 isErrorPage 속성 값을 true로 설정하면 이 변수를 사용할 수 있다.
</pre>

<%
// 빌트인 객체 사용하기
request.setAttribute("name","홍길동");
response.setHeader("aaa","okok");
pageContext.setAttribute("age",20);
session.setAttribute("tel","1111-2222");
application.setAttribute("gender", "m");
String user = config.getInitParameter("user");
out.println("hello");
out.println("<br>");
out.println(page.getClass().getName());
out.println("<br>");
out.println(exception);
out.println("<br>");
// 위의 9개 변수는 JSP 페이지에 존재하는 변수이기 때문에 컴파일 오류가 발생하지 않는다.
%>

</body>
</html>
<%!
int plus(int a, int b){
    return a + b;
}
%>