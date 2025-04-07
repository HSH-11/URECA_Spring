<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycom.myapp.auth.dto.UserDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
</head>
<body>
<%
    UserDto userDto = (UserDto) session.getAttribute("userDto");
    if (userDto != null) {
%>
    <h1><%= userDto.getUserid() %>님, 환영합니다 😊</h1>
<%
    } else {
%>
    <h1>로그인 정보를 확인할 수 없습니다.</h1>
<%
    }
%>
</body>
</html>
