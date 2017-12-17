package struts2.action;

import java.util.Map;   

import struts2.dao.UserDAO;
import struts2.dao.impl.UserDAOImpl;
import struts2.vo.User;
  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;   

public class LoginAction{   
  
    private User user;   
  
    private static final long serialVersionUID = 1L;   
  
    public String execute() throws Exception {   
        UserDAO dao = new UserDAOImpl();   
        int flag = dao.queryByUsername(user);   
        if(flag == 1){   
        	//session��һ���Ự�����ַ����û�״̬�� ServletActionContext. getRequest()�õ��û����� ServletActionContext. getRequest().getSession()�Ӹ��û������еõ��û���Session.
            Map session=(Map)ActionContext.getContext().get(ActionContext.SESSION);   
            session.put("user", user.getUsername());   
            return "success";
        } else {   
            return "error";   
        }   
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
  
    
}  

