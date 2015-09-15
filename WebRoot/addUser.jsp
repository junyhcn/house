<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="userAction!add" method="post">
		用户名:<input type="text" name="name" /><br /> 
		用户密码:<input type="text" name="pwd" /><br /> 
		用户姓名:<input type="text" name="userName" /><br /> 
		用户密码:<input	type="text" name="telephone" /><br /> 
		是否为管理员:<input type="text" name="admin" />	<br />

<input type="submit" value="注册"/>

	</form>
</body>
</html>
