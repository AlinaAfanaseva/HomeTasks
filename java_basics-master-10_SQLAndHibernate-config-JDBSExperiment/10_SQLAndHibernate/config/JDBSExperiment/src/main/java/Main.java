import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.afanaseva.jdbc.experiment.entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        //HQL task Course class
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root).where(builder.greaterThan(root.<Integer>get("price"), 50000))
                .orderBy(builder.desc(root.get("price")));
        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();

        for (Course course : courseList){
            System.out.println(course.getName() + " = " + course.getPrice());
        }

        CriteriaQuery<Teacher> query1 = builder.createQuery(Teacher.class);
        Root<Teacher> root1 = query1.from(Teacher.class);
        query1.select(root1).orderBy(builder.desc(root1.get("name")));
        List<Teacher> teacherList = session.createQuery(query1).getResultList();

        for (Teacher teacher : teacherList){
            System.out.println(teacher.getName());
        }

        CriteriaQuery<Student> query2 = builder.createQuery(Student.class);
        Root<Student> root2 = query2.from(Student.class);
        query2.select(root2).where(builder.between(root2.<Integer>get("age"), 20,30 ));
        List<Student> studentList = session.createQuery(query2).setMaxResults(6).getResultList();

        for (Student student : studentList){
            System.out.println(student.getAge());
        }

        sessionFactory.close();
    }
}


        //получаем информацию о каком-нибудь курсе
        //Transaction transaction = session.beginTransaction();
//        Course course = session.get(Course.class, 1);
//        List<Student> studentList = course.getStudents();
//        for (Student student : studentList){
//            System.out.println(student.getName());
//
//
//            System.out.println(student.getSubscriptions());
//        }
//
//        System.out.println(course.getDescription());
        //transaction.commit();
