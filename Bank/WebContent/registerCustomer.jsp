<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script language="javascript">
function back(){
	location.href="My"
	
}
</script>
</head>
<body>
<h3>회원가입</h3>
<%if(session.getAttribute("registerCustomerMSG")!=null){
		out.println(session.getAttribute("registerCustomerMSG"));
		session.removeAttribute("registerCustomerMSG");
	}
%>
<form action="registerCustomer" method="post">
	이름 : <input type="text" name="name"/><br/>
	주민등록번호 : <input type="text" name="pinnum1" maxlength="6"/>-<input type="password" name="pinnum2" maxlength="7"/><br/>
	주소 : <input type="text" name="address"><br/>
	아이디 : <input type="text" name="id"/><br/>
	비밀번호 : <input type="password" name="password"/><br/>
	<input type="submit" value="가입"/>
</form>
</body>
</html>