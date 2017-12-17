package myhibernate;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhibernate.Student;
import myhibernate.HiberDao;
public class StuServlet extends HttpServlet {
	
	 private HiberDao<Student> hiberdao=new HiberDao<Student>();
	 
	 protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req,resp);
	 
	}
	 
	 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     
	     String action=request.getParameter("action");
	    
	     if ("initAdd".equals(action)){
	    	 initAdd(request,response);
	     }else if("add".equals(action)){
	    	 add(request,response);
	     }else  if("save".equals(action)){
	    	 save(request,response);
	     }else  if("edit".equals(action)){
	    	 edit(request,response);
	     }else if("list".equals(action)){//显示所有的实体类对象
	    	 list(request,response);
	     }
	     else  if("delete".equals(action)){
	    	 delete(request,response);
	     }
	     else{//默认显示所有的实体类对象
	    	 list(request,response);
	     }
	 }
	 protected void initAdd(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		List<Student> stuList=hiberdao.list("select s from Student s");
		 req.setAttribute("stuList", stuList);
		 req.getRequestDispatcher("/addstudent.jsp").forward(req, resp);
		
	 }
	 protected void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setAttribute("stuList", hiberdao.list("from Student"));
	
		 req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);
		 List<Student> lis=hiberdao.list("from Student");
		 System.out.println("star------------star");
		 for(Student s:lis){
			 System.out.println(s.getStudentname());
		 }
	 }
protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	String  name=request.getParameter("name");
	String  ID=request.getParameter("ID");
	String birthday=request.getParameter("birthday");
	String address=request.getParameter("address");
	
	Student stu=new Student();
	stu.setAddress(address);
	stu.setBirthday(birthday);
	stu.setStudentID(ID);
	stu.setStudentname(name);
	hiberdao.create(stu);
	
	request.setAttribute("msg", "添加‘"+stu.getStudentname()+"’成功");
	list(request,response);
	
} 
protected void edit(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	String ID=req.getParameter("ID");
	Student stu=hiberdao.find(Student.class, ID);
	req.setAttribute("stu", stu);
	System.out.println("未跳转");
	req.getRequestDispatcher("/addstudent.jsp").forward(req, resp);
	System.out.println("已跳转");
} 
protected void save(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	String ID=req.getParameter("ID");
	String  name=req.getParameter("name");
	String birthday=req.getParameter("birthday");
	String address=req.getParameter("address");
	Student stu=hiberdao.find(Student.class, ID);
	stu.setAddress(address);
	stu.setBirthday(birthday);
	stu.setStudentname(name);
	hiberdao.update(stu);
	req.setAttribute("msg","保存‘"+stu.getStudentname()+"’成功");
	list(req,resp);
} 
protected void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	String ID=req.getParameter("ID");
	System.out.println("---->"+req.getParameter("ID"));
	Student stu=hiberdao.find(Student.class, ID);
	hiberdao.delete(stu);
	req.setAttribute("msg","删除‘"+stu.getStudentname()+"’成功");
	list(req,resp);
} 
}
