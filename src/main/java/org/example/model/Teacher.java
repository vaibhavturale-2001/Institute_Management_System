package org.example.model;

import java.util.List;

public class Teacher{
    int id,salary;
    String name,email;
    List<Student> studentList;

    public void setStudentList(List<Student> studentList){
        this.studentList=studentList;
    }
    public List<Student> getStudentList(){
        return studentList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
