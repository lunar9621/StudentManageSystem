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
    Hi: 
        欢迎<%=username%><br>  
    </p>
  <a href='<s:url value="/middle.jsp" />'>进入系统</a>
  </div> 
  </body>  
</html>  
