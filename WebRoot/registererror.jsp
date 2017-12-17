<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<%   
String username = (String)session.getAttribute("user");   
%>  
  <%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"> 
  </head>  
     
  <body>  
  <div class="login-header">
  <p>
       注册失败，用户已存在<br>  
   </p>
  <a href='<s:url value="/register.jsp" />'>重新注册</a>
  </body>  
</html>  
