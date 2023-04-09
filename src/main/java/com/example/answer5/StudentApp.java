package com.example.answer5;

import com.example.answer5.dao.StudentDAO;
import com.example.answer5.entity.Student;


public class StudentApp {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println(studentDAO.findAll());
        for (int i = 0; i < 1000; i++) {
            studentDAO.persist(new Student("student" + i, i));
        }
        System.out.println(studentDAO.findAll());
        System.out.println(studentDAO.findById(1055));
        Student student = studentDAO.findById(44);
        student.setName("Konst");
        studentDAO.update(student);
        System.out.println(studentDAO.findById(44));
    }
}