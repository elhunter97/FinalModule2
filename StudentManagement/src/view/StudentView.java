package view;

import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    public int view(){
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Display all student");
        System.out.println("4. Display information teacher");
        System.out.println("0. End program");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.print("Input your choice: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Choice must be number");
            } catch (Exception e) {
                System.out.println("Other exception");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }
    public Student viewAdd(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input birthday: ");
        String dob = sc.nextLine();
        System.out.print("Input gender(Male/Female): ");
        String gender = sc.nextLine();
        System.out.print("Input phone number: ");
        String phone = sc.nextLine();
        System.out.print("Input id class: ");
        String idClass = sc.nextLine();
        Student student = new Student(name,dob,gender,phone,idClass);
        return student;
    }

    public void viewMessage(boolean result) {
        if(result) {
            System.out.println("Successful Action");
        } else {
            System.out.println("Unsuccessful Action");
        }
    }

    public int inputID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id studnet: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public boolean confirmDelete(Student student) {
        System.out.println("Do you want to delete student have id "+ student.getId() +". Click Y to confirm, N to cancel");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if(confirm.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void displayAllStudent(List<Student> students) {
        System.out.println("List of all students: ");
        for (Student student: students) {
            System.out.println(infoStudent(student));
        }
    }

    private String infoStudent(Student student) {
        return "ID: " + student.getId() +", name: "+ student.getName()+" Birthday: "+student.getDob()+" Gender: "+student.getGender();
    }

}
