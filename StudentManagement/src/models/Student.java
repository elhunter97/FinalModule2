package models;

public class Student extends Person {
    private int id;
    private String idClass;
    private static int cnt = 0;
    public Student() {
    }

    public Student(String name, String dob, String gender, String phone,String idClass) {
        super(name, dob, gender, phone);
        this.id = cnt++;
        this.idClass = idClass;
    }

    public Student(int id,String name, String dob, String gender, String phone, String idClass) {
        super(name, dob, gender, phone);
        this.id = id;
        this.idClass = idClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

}
