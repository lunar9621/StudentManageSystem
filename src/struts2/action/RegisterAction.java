package struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import struts2.dao.UserDAO;
import struts2.dao.impl.UserDAOImpl;
import struts2.vo.User;


public class RegisterAction{   
		  
	    private User user;   
	  
	    private static final long serialVersionUID = 1L;   
	  
	    public String execute() throws Exception {
	    	
	        UserDAO dao = new UserDAOImpl(); 
	      //数据库中是否已经存在用户
	        int ishas=dao.queryByUsername(user);
	        if(ishas==1) return "has";
	        else{
	        int flag = dao.insert(user);   
	        System.out.println(flag);
	        if(flag == 1){   
	        	//session是一个会话，保持访问用户状态。 ServletActionContext. getRequest()得到用户请求 ServletActionContext. getRequest().getSession()从该用户请求中得到用户的Session.
	            Map session=(Map)ActionContext.getContext().get(ActionContext.SESSION);   
	            session.put("user", user.getUsername());   
	            return "success";
	        } else {   
	            return "error";   
	        }
	        }
	    }

		public User getUser() 	{
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}   
	  
	}
