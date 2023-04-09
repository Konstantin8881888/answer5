package com.example.answer5;



import com.example.answer5.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentSessionFactory {
    public StudentSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }
}
