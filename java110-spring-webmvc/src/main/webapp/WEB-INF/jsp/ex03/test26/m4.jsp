<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test26 - 4 페이지</h1>
<form method="post" action="m5">
<!-- 체크박스 체크 안하면 서버에 값이 안간다 -->
<input type="checkbox" name="language" value="java"/>자바<br>
<input type="checkbox" name="language" value="c"/>C/C++<br>
<input type="checkbox" name="language" value="sql"/>SQL<br>
<input type="checkbox" name="language" value="python"/>Python<br>
<input type="checkbox" name="language" value="javascript"/>Javascript<br>
<button>다음</button>
</form>
</body>
</html>