package myhibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Test {
	public static void main(String[] args) {  
        
        //读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure();  
        cfg.addClass(myhibernate.Student.class);
          
        //建立SessionFactory   
        SessionFactory factory = cfg.buildSessionFactory();  
          
        //取得session  
        Session session = null;  
        try {  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
            Student student = new Student ();  
            student.setStudentname("张三");  
            student.setStudentID("123");  
            student.setBirthday("123");  
            student.setAddress("erer");  
              
            System.out.println(student.getAddress());
            //保存User对象  
            session.save(student);  
              
            //提交事务  
            session.getTransaction().commit();  
        }catch(Exception e) {  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally {  
            if (session != null) {  
                if (session.isOpen()) {  
                    //关闭session  
                    session.close();  
                }  
            }  
        }  
    }  
}
