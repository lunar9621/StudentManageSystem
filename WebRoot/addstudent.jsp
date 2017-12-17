<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.List"%>
<%@page import="myhibernate.Student" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<p class="listword">${ param.action == 'initAdd'?'添加学生资料':'修改学生资料'}</p>
[<a class="listword2" href="StuServlet?action=initAdd">添加学生</a>][<a class="listword3" href="StuServlet?action=list">学生列表</a>]
 <form action="StuServlet" method="post">
 <input type="hidden" name="action" value="${param.action=='initAdd'?'add':'save'}">
 <table class="list">
 <tr>
   <td>Name:</td>
   <td><input type="text" name="name" /></td>
  </tr>
   <tr>
   <td>Birthday:</td>
   <td><input type="text" name="birthday" /></td>
  </tr>
   <tr>
   <td>Address:</td>
   <td><input type="text" name="address" /></td>
  </tr>
  <tr>
   <td>ID:</td>
   <td><input type="text" name="ID" /></td>
  </tr>
  <tr>
  <td></td>
  <td><input type=submit value="${ param.action=='initAdd'?'提交':'保存'}"/></td>
  </tr>
  </table>
  </form>
  </body>
</html>
