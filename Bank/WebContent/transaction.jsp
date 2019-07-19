<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<body>
<head>
<script language="javascript">
function check(){
	if(tran.sendmoney.value !="" && tran.receiveaccount.value !="" &&tran.account.value !="")
		return true;
	else
		return false;
}
</script>
<meta charset="EUC-KR">
<h2>계좌이체</h2>
</head>
<body>
<form name="tran" action="Transaction" method="post" onsubmit="return check()">
<%for(String account:(ArrayList<String>)request.getAttribute("account")) {%>
<input type="radio" name="checkaccount" value=<%=account %>><%=account %></input><br><%} %>
보낼 돈 <input type="number" name="sendmoney" /><br>
받을사람 계좌<input type="text" name="receiveaccount" /><br>
<input type="submit" value="전송">
</form>
</body>
</html>