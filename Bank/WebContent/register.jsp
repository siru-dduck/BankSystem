<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function back(){
	location.href="My"
	}
</script>
<body>
수정하기
<form action="My" method="post">
<input type="button" value="뒤로" onclick="back()">
<input type="submit" value="확인">
</form>
</body>
</html>