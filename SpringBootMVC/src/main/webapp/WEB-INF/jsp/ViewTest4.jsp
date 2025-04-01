<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import = "com.mycom.myapp.dto.CarDto" %>
<%
String seq = (String) request.getAttribute("seq");
CarDto carDto = (CarDto) request.getAttribute("carDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>viewTest4.jsp</h1>
	<h4>seq : <%= seq %></h4>
	<h1>CarDto</h4>
	<h4>name : <%=carDto.getName() %></h4>
	<h4>price : <%=carDto.getPrice() %></h4>
	<h4>owner : <%=carDto.getOwner() %></h4>
</body>
</html>