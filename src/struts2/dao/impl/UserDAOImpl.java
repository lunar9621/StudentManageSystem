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
  
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt.setString(1,user.getUsername()) ;     
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
                if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
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
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            result=pstmt.executeUpdate(sql);
            if(result==1) flag=1;
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
        	if(pstmt !=null) pstmt.close();
        	if(dbc!=null) dbc.close() ;   
        }   
		return flag;
	}

}
