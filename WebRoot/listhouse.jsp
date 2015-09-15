<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listhouse.jsp' starting page</title>
    
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
  <div style="width:500px;height:180px">
  <form action="houseAction!query" method="post">
   房型:<select name="type_id">
            <option value="-1">请选择</option>
			<c:forEach items="${tlist }" var="type">
				<option value="${type.id}">${type.name }</option>
			</c:forEach>
		</select>
		 街道:<select name="street_id">
		     <option value="-1">请选择</option>
			<c:forEach items="${slist }" var="street">
				<option value="${street.id}">${street.name }</option>
			</c:forEach>
		</select><br />
    价格:从<input type="text" name="lprice"/>到 <input type="text" name="hprice"/><br/>
 楼层 :<input type="text" name="floorage"/><br/>
    <input type="submit" value="查询"/>
    </form>
  </div>
   <c:forEach items="${hlist }" var="house">
    ${house.title }:
    ${house.price }<br/>
    ${house. contact}:
    ${house.floorage }<br/>
    街道:${house.street.name }  房型：${house.type.name }
    <hr/>
   
   </c:forEach>
  </body>
</html>
