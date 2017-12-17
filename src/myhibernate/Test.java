package myhibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Test {
	public static void main(String[] args) {  
        
        //��ȡhibernate.cfg.xml�ļ�  
        Configuration cfg = new Configuration().configure();  
        cfg.addClass(myhibernate.Student.class);
          
        //����SessionFactory   
        SessionFactory factory = cfg.buildSessionFactory();  
          
        //ȡ��session  
        Session session = null;  
        try {  
            session = factory.openSession();  
            //��������  
            session.beginTransaction();  
            Student student = new Student ();  
            student.setStudentname("����");  
            student.setStudentID("123");  
            student.setBirthday("123");  
            student.setAddress("erer");  
              
            System.out.println(student.getAddress());
            //����User����  
            session.save(student);  
              
            //�ύ����  
            session.getTransaction().commit();  
        }catch(Exception e) {  
            e.printStackTrace();  
            //�ع�����  
            session.getTransaction().rollback();  
        }finally {  
            if (session != null) {  
                if (session.isOpen()) {  
                    //�ر�session  
                    session.close();  
                }  
            }  
        }  
    }  
}
