<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charSet='UTF-8'>
<title>로그인</title>
<style>
th {
	text-align: right;
}
</style>
</head>
<body>
	<h1>로그인</h1>
	<form action='login' method='post'>
		<table>
			<tr>
				<th></th>
				<td><input type='radio' name='type' value='student' checked>학생
					<input type='radio' name='type' value='teacher'>강사 <input
					type='radio' name='type' value='manager'>매니저</td>
			</tr>
			<tr>
				<th>이메일</th>
<jsp:useBean scope="request"
             id="email"
             class="java.lang.String"/>
<%
//String email = (String)request.getAttribute("email");
%>
				<td><input type='email' name='email' value='${cookie.email.value}'></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<th></th>
<%

if("".equals(email)) {
%>    
    <td><input type='checkbox' name='save'>이메일 저장</td>
<%    
} else {
%>
    <td><input type='checkbox' name='save' checked>이메일 저장</td>
<%
}
%>
			</tr>
			<tr>
				<th></th>
				<td><button>로그인</button>
				<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                </fb:login-button>
                </td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
// 로그인 성공한 후 서버에 자동으로 로그인 하기
// => 페이스북으로부터 사용자 정보 가져오기
function autoLogin(accessToken) {
    var type = document.querySelector("input[name='type']:checked").value;
    location.href = "fblogin?type="+type+"&accessToken="+accessToken;
}

function statusChangeCallback(response) {
  console.log(response);

  if (response.status === 'connected') { // 로그인이 정상적으로 되었을 때,
      autoLogin(response.authResponse.accessToken);
  
  } else { // 로그인이 되지 않았을 때,
      alert('Facebook 로그인 실패!')
  }
}
  
function checkLoginState() {
    FB.getLoginStatus(function(response) { 
      statusChangeCallback(response);
    });
}

window.fbAsyncInit = function() {
  console.log("window.fbAsyncInit() 호출됨!");
  FB.init({
    appId      : '276928149622484', // 개발자가 등록한 앱 ID
    cookie     : true,  
    xfbml      : true,  
    version    : 'v3.2' 
  });
  FB.AppEvents.logPageView();
};

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


</script>	
</body>
</html>

