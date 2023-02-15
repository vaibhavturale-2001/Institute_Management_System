package org.example.repository;

import org.example.model.Teacher;
import org.example.repository.Impl.TeacherRepoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Repository
public class TeacherRepository implements TeacherRepoImpl{
    String url="jdbc:mysql://localhost:3306/testinstitute";
    String userName="root";
    String password="";

    @Override
    public Teacher teacherSelfUpdate(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            String sids=String.valueOf(t1.getStudentList().get(0).getRollNo());
            for(int i=1;i<t1.getStudentList().size();i++){
                sids=sids+","+t1.getStudentList().get(i).getRollNo();
            }
            st.executeUpdate("update teacher set salary='"+t1.getSalary()+"',name='"+t1.getName()+"',email='"+t1.getEmail()+"','"+sids+"'where id='"+t1.getId()+"'");
        }catch (Exception e){
            System.out.println(e);
        }
        return t1;

        //===============Student=========================
    }
}
