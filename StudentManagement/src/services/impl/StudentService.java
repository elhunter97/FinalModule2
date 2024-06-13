package services.impl;

import models.Student;
import repositories.StudentRepositories;
import services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private StudentRepositories studentRepositories = new StudentRepositories();
    @Override
    public boolean addStudent(Student student) {
        String dateFormat = "(^0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4}$)";
        String phoneFormat = "(090|091)\\d{7}";
        if(!student.getDob().matches(dateFormat)){
            return false;
        }
        if(!student.getPhone().matches(phoneFormat)){
            return false;
        }
        studentRepositories.addStudent(student);
        return true;
    }

    @Override
    public void removeStudent(Student student) {
        studentRepositories.removeStudent(student);
    }

    @Override
    public Student findByID(int id) {
        return studentRepositories.findByID(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepositories.getAll();
    }
}
