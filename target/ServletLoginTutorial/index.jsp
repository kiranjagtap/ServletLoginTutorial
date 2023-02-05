<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<body>
<h2>Login Form</h2>
<form action="/login.do" method="post">
<label for="username">Enter Username</label>
<br><br>
<input type="text" name="username">
<br><br>
<label for="password">Enter Password</label>
<br><br>
<input type="password" name="password">
<br><br>
<input type="submit">
<br>
<br>
<br>

<b>
<%

String servletName = config.getServletName();
String contectPath = application.getContextPath();

out.println("servlet name "+servletName);
%>
</b>
</body>
</html>
