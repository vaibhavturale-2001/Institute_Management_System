package org.example.repository;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.ManagementRepoImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagementRepository implements ManagementRepoImpl {

    //=======================Teacher========================
    String url="jdbc:mysql://localhost:3306/testinstitute";
    String userName="root";
    String password="";
    @Override
    public void insertSingleTeacher(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("insert into teacher values('"+t1.getId()+"','"+t1.getSalary()+"','"+t1.getName()+"','"+t1.getEmail()+"','"+t1.getStudentList()+"')");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Teacher selectSingleTeacher(int id){
        Teacher t1=new Teacher();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from teacher where id='"+id+"'");
            while (rs.next()){
                t1.setId(rs.getInt(1));
                t1.setSalary(rs.getInt(2));
                t1.setName(rs.getString(3));
                t1.setEmail(rs.getString(4));
                //t1.setStudentList(rs.get(5));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return t1;
    }
    @Override
    public List<Teacher> selectAllTeacher(){
        List<Teacher> teacherList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from teacher");
            while(rs.next()) {
                Teacher t1 = new Teacher();
                t1.setId(rs.getInt(1));
                t1.setSalary(rs.getInt(2));
                t1.setName(rs.getString(3));
                t1.setEmail(rs.getString(4));
                //t1.setStudentList();
                teacherList.add(t1);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        return teacherList;
    }
    @Override
    public Teacher updateSingleTeacher(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update teacher set salary='"+t1.getSalary()+"',name='"+t1.getName()+"',email='"+t1.getEmail()+"','"+t1.getStudentList()+"'where id='"+t1.getId()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingleTeacher(t1.getId());
    }
    @Override
    public  Boolean deleteSingleTeacher(int id){
        boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int teacherResult=st.executeUpdate("delete from teacher where id='"+id+"'");
            if(teacherResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public  Boolean deleteAllTeacher(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int teacherResult=st.executeUpdate("delete from teacher");
            if(teacherResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }


    //=======================Student============================

    @Override
    public void insertSingleStudent(Student s1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("insert into student values('"+s1.getRollNo()+"','"+s1.getFees()+"','"+s1.getAttendance()+"','"+s1.getName()+"','"+s1.getEmail()+"','"+s1.getBranch()+"')");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Student selectSingleStudent(int id){
        Student s1=new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student where id='"+id+"'");
            while (rs.next()){
                s1.setRollNo(rs.getInt(1));
                s1.setFees(rs.getInt(2));
                s1.setAttendance(rs.getInt(3));
                s1.setName(rs.getString(4));
                s1.setEmail(rs.getString(5));
                s1.setBranch(rs.getString(6));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return s1;
    }
    @Override
    public List<Student> selectAllStudent(){
        List<Student> studentList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            while(rs.next()) {
                Student s1 = new Student();
                s1.setRollNo(rs.getInt(1));
                s1.setFees(rs.getInt(2));
                s1.setAttendance(rs.getInt(3));
                s1.setName(rs.getString(4));
                s1.setEmail(rs.getString(5));
                s1.setBranch(rs.getString(6));
                studentList.add(s1);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Student updateSingleStudent(Student s1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update teacher set fees='"+s1.getFees()+"',attendence='"+s1.getAttendance()+"',name='"+s1.getName()+"',email='"+s1.getEmail()+"','"+s1.getBranch()+"'where id='"+s1.getRollNo()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingleStudent(s1.getRollNo());
    }
    @Override
    public  Boolean deleteSingleStudent(int id){
        boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int studentResult=st.executeUpdate("delete from student where id='"+id+"'");
            if(studentResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public  Boolean deleteAllStudent(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int studentResult=st.executeUpdate("delete from student");
            if(studentResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }


}
