package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("3hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete Employee where name = 'Aleksandr'")
                    .executeUpdate();

//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(333);
//
//            session.createQuery("update Employee set salary=1000 where name = 'Aleksandr'")
//                            .executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
