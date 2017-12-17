<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.List"%>
<%@page import="myhibernate.Student" %>

<html>
<head>       
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
  </head>  
<body>

<form action="StuServlet?action=list" method="post">

<td width=300px>
<div class="liststu">
<input type=submit value="查看所有学生"/>
</div>
</td>
</body>

</html>