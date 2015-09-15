<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>My JSP 'addHouse.jsp' starting page</title>

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
<h1>${sessionScope.user.name }</h1>
<hr/>
	<form action="houseAction!add" method="post">
		标题:<input type="text" name="title" /><br /> 房型:<select name="type_id">
			<c:forEach items="${tlist }" var="type">
				<option value="${type.id}">${type.name }</option>
			</c:forEach>
		</select><br /> 街道:<select name="street_id">
			<c:forEach items="${slist }" var="street">
				<option value="${street.id}">${street.name }</option>
			</c:forEach>
		</select><br /> 楼层：<input type="text" name="floorage" /><br /> 联系人:<input
			type="text" name="contact" /><br /> 价格:<input type="text"
			name="price" /><br /> 说明:<input type="text" name="description" /><br />
		<input type="submit" value="提交" />



	</form>
</body>
</html>
