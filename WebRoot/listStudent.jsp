<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.List"%>
<%@ page import="myhibernate.Student" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<h4>${ msg }</h4>
<p class="listword">所有学生列表</p>
[<a class="listword2" href="StuServlet?action=initAdd">添加学生</a>][<a class="listword3" href="StuServlet?action=list">学生列表</a>]

<table class="list">
  <tr>
    <th>姓名</th>
    <th>ID</th>
    <th>生日</th> 
    <th>住址</th>
    <th>操作</th>
  </tr>
  <%
  @SuppressWarnings("unchecked")
  List<Student> stuList=(List<Student>) request.getAttribute("stuList");
  for(Student stu:stuList){
  out.write("<tr>");
  out.write("<td>"+stu.getStudentname()+"</td>");
  out.write("<td>"+stu.getStudentID()+"</td>");
  out.write("<td>"+stu.getBirthday()+"</td>");
  out.write("<td>"+stu.getAddress()+"</td>");
  out.write("<td>");
  out.write(" <a href=StuServlet?action=delete&ID="+stu.getStudentID()+" onclick=\"return confirm('确定删除？');\">删除</a>");
  out.write(" <a href=StuServlet?action=edit&ID="+stu.getStudentID()+ ">修改</a>");
  out.write("</td>");
  out.write("</tr>");
  } 
   %>
</table>