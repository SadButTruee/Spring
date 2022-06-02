package hibernate.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("3hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 3);
            System.out.println(department);
            System.out.println(department.getEmployees());

//            Employee employee1 = new Employee("Ivan", "Ivanov", 500);
//            Employee employee2 = new Employee("Petr", "Petrov", 600);
//            Department department = new Department("IT", 100, 1000);
//            department.addEmployeeDepartment(employee1);
//            department.addEmployeeDepartment(employee2);
//            session.save(department);

//            Employee employee1 = session.get(Employee.class, 1);
//            employee1.setDepartment(null);
//            session.delete(employee1);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
