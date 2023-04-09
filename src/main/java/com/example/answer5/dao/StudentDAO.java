package com.example.answer5.dao;

import com.example.answer5.StudentSessionFactory;
import com.example.answer5.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO implements AutoCloseable{
    private final Session session;

    public StudentDAO() {
        this.session = StudentSessionFactory.getSessionFactory().openSession();
    }

    public void persist(Student student) {
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public Student findById(Integer id) {
        return session.get(Student.class, id);
    }

    public void update(Student entity) {
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
    }

    public void delete(Student entity) {
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
    }

    public List<Student> findAll() {
        return session.createQuery("from Student", Student.class).list();
    }

    public void deleteAll() {
        Transaction transaction = session.beginTransaction();
        List<Student> entityList = findAll();
        for (Student entity : entityList) {
            session.delete(entity);
        }
        transaction.commit();
    }

    @Override
    public void close() throws Exception {
        closeConnect();
    }

    public void closeConnect() {
        session.close();
    }
}
