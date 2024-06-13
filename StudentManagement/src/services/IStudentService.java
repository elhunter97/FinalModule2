package services;

import models.Student;

import java.util.List;

public interface IStudentService {
    boolean addStudent(Student student);
    void removeStudent(Student student);

    Student findByID(int id);

    List<Student> getAll();
}
