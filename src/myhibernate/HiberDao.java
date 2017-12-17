package myhibernate;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public class HiberDao<T> {
	//插入
public void create(T object){
	Session  session=HibernateUtil.getSessionFactory().openSession();
try{
	session.beginTransaction();
	session.persist(object);
	session.getTransaction().commit();
}catch(Exception e){
	session.getTransaction().rollback();
}finally{
	session.close();
}
}
//更新
public void update (T object){
	Session session=HibernateUtil.getSessionFactory().openSession();
	try{
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}catch(Exception e){
		session.getTransaction().rollback();
	}finally{
		session.close();
	}
}
//删除
public void delete (T object){
	Session session=HibernateUtil.getSessionFactory().openSession();
	try{
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}catch(Exception e){
		session.getTransaction().rollback();
	}finally{
		session.close();
	}
}
//根据id查询
@SuppressWarnings("unchecked")
public T find(Class <?extends T> clazz,Serializable id){
	Session  session=HibernateUtil.getSessionFactory().openSession();
	try{
		session.beginTransaction();
		return (T) session.get(clazz, id);
	}finally{
		session.getTransaction().commit();
		session.close();
	}
}
@SuppressWarnings("unchecked")
public List<T> list(String hql){
	Session session=HibernateUtil.getSessionFactory().openSession();
	try{
		session.beginTransaction();
		return session.createQuery(hql).list();
	}finally{
		session.getTransaction().commit();
		session.close();
	}
	
}
}
