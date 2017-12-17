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
    Hi:<br>  
    <%=username%><br>  
       注册成功，若登陆请点击链接<br>  
  <a href='<s:url value="/login.jsp" />'>登录</a>
  </body>  
</html>  
