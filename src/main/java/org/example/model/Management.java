package org.example.model;

import java.util.List;

public class Management{
    int id,salary;
    String name,email;
    List<Teacher> teacherList;

    public void setTeacherList(List<Teacher> teacherList){
        this.teacherList=teacherList;
    }
    public List<Teacher> getTeacherList(){
        return teacherList;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId(){
        return id;
    }
    public int getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
}
