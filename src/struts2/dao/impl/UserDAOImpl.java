 package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import struts2.dao.UserDAO;
import struts2.db.DBConnect;
import struts2.vo.User;

public class UserDAOImpl implements UserDAO { 

	@Override
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
  
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt.setString(1,user.getUsername()) ;     
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return flag;
	}
	
	public int insert(User user) throws Exception{
		int flag=0;
		String sql =  "insert into userinfo values('"+user.getUsername()+"','"+user.getPassword()+"');";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
          int result=0;
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            result=pstmt.executeUpdate(sql);
            if(result==1) flag=1;
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
        	if(pstmt !=null) pstmt.close();
        	if(dbc!=null) dbc.close() ;   
        }   
		return flag;
	}

}
