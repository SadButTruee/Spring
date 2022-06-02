package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("3hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Elena", "Petrova", "Sales", 600);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            int id = employee.getId();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee emp2 = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(emp2);
        } finally {
            sessionFactory.close();
        }
    }
}
