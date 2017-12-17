package struts2.dao;

import java.util.List;

import struts2.vo.User;
public interface UserDAO {
	public int queryByUsername(User user) throws Exception;
    public int insert(User user) throws Exception;
}
