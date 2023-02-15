package org.example.repository;

import org.example.model.Student;
import org.example.repository.Impl.StudentRepoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Repository
public class StudentRepository implements StudentRepoImpl {

    @Override
    public Student selfUpdate(Student s1){
        try{
            String url="jdbc:mysql://localhost:3306/testinstitute";
            String userName="root";
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update student set fees='"+s1.getFees()+"',attendance='"
                                                        +s1.getAttendance()+"',name='"
                                                        +s1.getName()+"',email='"
                                                        +s1.getEmail()+"',branch='"
                                                        +s1.getBranch()+"'where rollNo='"
                                                        +s1.getRollNo()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return s1;
    }
}
