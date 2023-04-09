package com.example.answer5;

import com.example.answer5.dao.StudentDAO;
import com.example.answer5.entity.Student;

import java.util.List;

public class StudentApp {

    public static void main(String[] args) {
        try (StudentDAO studentDAO = new StudentDAO()) {
            List<Student> students = studentDAO.findAll();

            System.out.println(students);
            for (int i = 0; i < 1000; i++) {
                studentDAO.persist(new Student("student" + i, i));
            }
            System.out.println(students);
            System.out.println(studentDAO.findById(55));
            Student student44 = studentDAO.findById(44);
            System.out.println(student44);
            student44.setName("Konst");
            studentDAO.update(student44);
            System.out.println(studentDAO.findById(44));
            studentDAO.delete(student44);
            students = studentDAO.findAll();
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
