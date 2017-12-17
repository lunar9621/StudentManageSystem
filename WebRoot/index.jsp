<%@ page language="java" contentType="text/html;charset=UTF-8"%>
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
<body>
<div class="head" >
     <p>学生信息管理系统</p>
 </div>
 <br>
 <div class="login-header" >
 <a href='<s:url value="/login.jsp" />'>登录</a>
 </div>
 <div class="register-header">
       <a href='<s:url value="/register.jsp" />'>注册</a>
 </div>
</body>
</html>

