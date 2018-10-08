<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리</title>
<link rel='stylesheet' href='/css/common.css'>
<style>
th {
    text-align : right;
}
</style>
</head>
<body>
    <h1>학생 등록(MVC)</h1>
    <jsp:include page="../header.jsp"/>
    <form action='add' method='post'>
        <table>
            <tbody>
                <tr>
                    <th>이름</th>
                    <td><input type='text' name='name'></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type='text' name='email'></td>
                </tr>
                <tr>
                    <th>암호</th>
                    <td><input type='password' name='password'></td>
                </tr>
                <tr>
                    <th>최종학력</th>
                    <td><input type='text' name='school'></td>
                </tr>
                <tr>
                    <th>재직여부</th>
                    <td><input type='text' name='work'></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td><input type='text' name='tel'></td>
                </tr>
                <tr>
                    <th></th>
                    <td><button type='submit'>전송</button></td>
                </tr>
            </tbody>
        </table>
    </form>
    <jsp:include page="../footer.jsp"/>
</body>
</html>