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
  <div class="login-header">  
    <s:form action="register">  
        <s:textfield name="user.username" label="用户名"></s:textfield> 
         <s:password name="user.password" label="密码"></s:password>
             <s:submit value="注册"></s:submit>  
    </s:form>  
    </div>
  </body>
</html>
