<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  <head>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
  </head>
  
  <body class="login-header">
    <p>用户不存在 <br></p>
  <a href='<s:url value="/register.jsp" />'>注册</a>
  </body>
 
</html>
