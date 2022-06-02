package hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("3hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = new Employee("Misha", "Sidorov", "HR", 500);
//            Detail detail = new Detail("London", "98795364535", "mishasidorov@gmail.com");
//            detail.setEmployee(employee);
//            employee.setDetail(detail );
//
//            session.save(detail);
            Detail detail = session.get(Detail.class, 3);
            System.out.println("\n" + detail + "\n");
            session.delete(detail);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
