<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL 표기법</h1>
<pre>
- EL(Expression Language)은 콤마(,)와 대괄호([]) 등을 사용하여 객체의 프로퍼티나, 
  리스트, 셋, 맵 객체의 값을 쉽게 꺼내고 설정하게 도와주는 문법이다.
  특히 값을 꺼낸 때는 OGNL 표기법을 사용한다.
- OGNL (Object Graph Navigation Language)?
  객체의 프로퍼티 값을 가리는 문법이다.
 파일의 경로처럼 객체에 포함된 객체를 탐색하여 값을 쉽게 조회할 수 있다.
- 문법
  $ { 객체명.프로퍼티명.프로퍼티명.프로퍼티명}
  $ { 객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"] }
  
- EL에서 사용할 수 있는 객체?
     pageContext - JSP의 pageContext 객체
     servletContext - ${pageContext.servletContext.프로퍼티명 }
                자바코드: pageContext.getServletContext().get프로퍼티();
     session - ${pageContext.session.프로퍼티명 }
               예) $ { pageContext.session.name }
               => pageContext.getSession().getName(); 세션에서 값을 꺼내는게 아니다.
     
     request - ${pageContext.request.프로퍼티명 }
     response
     param - ${param.파라미터명 }
            => request.getParameter("파라미터명")
     paramValues - $ { paramValues.파리미터명 }
            => request.getParameterValues("파라미터명");
     headerValues - $ { headerValues.헤더명 }
            => request.getHeaders("헤더명");
     cookie - $ { cookie.쿠키명 }
     initParam - ${ initParam.파라미터명 }
     
     보관소에서 값을 꺼내기
     pageScope - $ { pageScope.프로퍼티명 }
            => pageContext.getAttribute("객체이름");
     requestScope - $ { requestScope.프로퍼티명 }
            => request.getAttribute("객체이름");
     sessionScope - $ { sessionScope.프로퍼티명 }
            => session.getAttribute("객체이름");
     applicationScope - $ { applicationScope.프로퍼티명 }
            => application.getAttribute("객체이름");
</pre>

</body>
</html>