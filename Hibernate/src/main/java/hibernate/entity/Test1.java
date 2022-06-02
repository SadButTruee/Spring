package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("3hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            //Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Aleksandr", "Ivanov", "IT", 600);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
            System.out.println(employee);
        } finally {
            sessionFactory.close();
        }
    }
}
