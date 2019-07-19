<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>

<body>

	<%if(session.getAttribute("loginMSG")!=null){
		out.println(session.getAttribute("loginMSG"));
		session.removeAttribute("loginMSG");
	}
	%>

	<form action="loginCheck" method="post">

		아이디 : <input type="text" name="bankid"/>

		비밀번호 : <input type="password" name="password"/><br/>

		<input type="submit" value="로그인">

		<input type="button" id="registerCustomer" value="회원가입">

	</form>

	<script>
		var element = document.getElementById('registerCustomer');
		element.addEventListener('click',function(event){
			location.href='registerCustomer.jsp';
		});
	</script>

</body>

</html>