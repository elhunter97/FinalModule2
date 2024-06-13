package controllers;

import models.Student;
import services.IStudentService;
import services.impl.StudentService;
import view.StudentView;

import java.util.List;

public class MainController {

    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        IStudentService studentService = new StudentService();
        Student student;
        boolean result;
        int choice;
        List<Student> students;
        while (true) {
            choice = studentView.view();
            switch (choice) {
                case 1:
                    student = studentView.viewAdd();
                    result = studentService.addStudent(student);
                    studentView.viewMessage(result);
                    break;
                case 2:
                    int id = studentView.inputID();
                    student = studentService.findByID(id);
                    if(student == null) {
                        studentView.viewMessage(false);
                    } else {
                        boolean isConfirm = studentView.confirmDelete(student);
                        if(isConfirm) {
                            studentService.removeStudent(student);
                            studentView.viewMessage(true);
                        }
                    }
                    break;
                case 3:
                    students = studentService.getAll();
                    studentView.displayAllStudent(students);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ending program");
                    return;
            }
            System.out.println();
        }
    }
}
