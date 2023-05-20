package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.TeacherRepoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository implements TeacherRepoImpl{
    String url="jdbc:mysql://localhost:3306/testinstitute";
    String userName="root";
    String password="";

    @Override
    public Teacher teacherSelfUpdate(Teacher t1) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set salary='" + t1.getSalary() + "',name='" + t1.getName() + "',email='" + t1.getEmail() + "'where id='" + t1.getId() + "'");
        } catch (Exception e){
            System.out.println(e);
        }
        return t1;
    }
        //===============Student=========================

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
    public Student selectSingleStudent(int rollNo){
        Student s1=new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student where rollNo='"+rollNo+"'");
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
            st.executeUpdate("update student set fees='"+s1.getFees()+"',attendance='"+s1.getAttendance()+"',name='"+s1.getName()+"',email='"+s1.getEmail()+"',branch='"+s1.getBranch()+"' where rollNo='"+s1.getRollNo()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingleStudent(s1.getRollNo());
    }
    @Override
    public  Boolean deleteSingleStudent(int rollNo){
        boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int studentResult=st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
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
                System.out.println(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

}
