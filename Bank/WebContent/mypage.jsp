<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="dto.Accountdto"%>
<!DOCTYPE html>
<html>
<head>
<script language="javascript">
function back(){
	location.href="/Bank"
}
function update(){
	location.href="My?update"
}
</script>
<meta charset="EUC-KR">
<h2><%=session.getAttribute("login") %> 님의정보</h2>
</head>
<body>
<%for(Accountdto account:(ArrayList<Accountdto>)request.getAttribute("account")) {%>
계좌정보<br>
<a><%=account.getAccountnumber() %> 잔액  <%=account.getBalance() %> </a><br>
<%} %>
<button onclick="back()">뒤로</button>
<button onclick="update()">수정</button>

</body>
</html>