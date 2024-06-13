package repositories;

import models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositories {
    private static final String SRC_STUDENT = "src/data/students.csv";
    private static List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        List<Student> students1 = getAll();
        students1.add(student);
        writeFile(students1,false);
    }

    public void removeStudent(Student student){
        List<Student> students = getAll();
        int size =students.size();
        for (int i = 0; i < size; i++) {
            if(students.get(i).getId() == (student.getId())){
                students.remove(i);
                break;
            }
        }
        writeFile(students,false);
    }

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        File file = new File(SRC_STUDENT);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null){
                String[] temp = line.split(",");
//                int id,String name, String dob, String gender, String phone, String idClass
                students.add(new Student(Integer.parseInt(temp[0]),temp[1],temp[2],temp[3],temp[4],temp[5]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error read data");
        }finally {
            if(br!=null){
                try{
                    br.close();
                }catch (IOException e){
                    System.out.println("Error close file");
                }
            }
        }
        return students;
    }

    public void writeFile(List<Student> students, boolean append){
        File file = new File(SRC_STUDENT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Student temp: students) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error write file");
        } finally {
            if(bufferedWriter !=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error close file");
                }
            }
        }
    }

    private String toString(Student student) {
        return student.getId()+","+student.getName()+","+student.getDob()+","+student.getGender()+","+student.getPhone()+","+student.getIdClass();
    }


    public Student findByID(int id) {
        List<Student> students = getAll();
        for (Student student : students) {
            if(student == null) {
                return null;
            }
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
