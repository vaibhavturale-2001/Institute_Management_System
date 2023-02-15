package org.example.repository;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.AdminRepoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

@Repository
public class AdminRepository implements AdminRepoImpl{
    String url="jdbc:mysql://localhost:3306/testinstitute";
    String userName="root";
    String password="";
    @Override
    public void insertSingleManagement(Management m1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            //String tids="1,2,3,4";
            String tids=String.valueOf(m1.getTeacherList().get(0).getId());
            for(int i=1;i<m1.getTeacherList().size();i++) {
            tids = tids + "," + m1.getTeacherList().get(i).getId();
            }
            System.out.println(tids);
            st.executeUpdate("insert into management values('"+m1.getId()+"','"
                    +m1.getSalary()+"','"+m1.getName()+"','"+m1.getEmail()+"','"+tids+"')");


            for(int i=0;i<m1.getTeacherList().size();i++){
                String sids = String.valueOf(m1.getTeacherList().get(i).getStudentList().get(0).getRollNo());

                for(int j=1;j<m1.getTeacherList().get(i).getStudentList().size();j++){
                    sids=sids+","+m1.getTeacherList().get(i).getStudentList().get(i).getRollNo();
                }
                System.out.println(sids);
                st.executeUpdate("insert into teacher values('" + m1.getTeacherList().get(i).getId() + "','"
                        + m1.getTeacherList().get(i).getName() + "','"
                        + m1.getTeacherList().get(i).getEmail() + "','"+sids+"',)");

            }


            for(int i=0;i<m1.getTeacherList().size();i++){
                for(int j=0;j<m1.getTeacherList().get(i).getStudentList().size();j++){
                    st.executeUpdate("insert into student values('"+m1.getTeacherList().get(i).getStudentList().get(j).getRollNo()+"','"
                            +m1.getTeacherList().get(i).getStudentList().get(j).getFees()+"','"
                            +m1.getTeacherList().get(i).getStudentList().get(j).getAttendance()+"','"
                            +m1.getTeacherList().get(i).getStudentList().get(j).getName()+"','"
                            +m1.getTeacherList().get(i).getStudentList().get(j).getEmail()+"','"
                            +m1.getTeacherList().get(i).getStudentList().get(j).getBranch()+"')");

                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
    @Override
    public  Management selectSingleManagement(int id){
        Management m1=new Management();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();

            List<Integer>tid=new ArrayList<>();
            ResultSet rs=st.executeQuery("select * from management where id='"+id+"'");
            while(rs.next()){
                m1.setId(rs.getInt(1));
                m1.setSalary(rs.getInt(2));
                m1.setName(rs.getString(3));
                m1.setEmail(rs.getString(4));
                String m2= rs.getString(5);
                String [] m2Split = m2.split(",");
                for(int i = 0 ; i < m2Split.length;i++) {
                    tid.add(Integer.parseInt(m2Split[i]));
                }
            }
            List<Integer>sid=new ArrayList<>();
            List<Student> studentList=new ArrayList<>();
            List<Teacher>teacherList=new ArrayList<>();
            ResultSet rs1=st.executeQuery("select * from teacher where id='"+id+"'");
            while(rs1.next()){
                Teacher t1=new Teacher();
                t1.setId(rs1.getInt(1));
                t1.setSalary(rs1.getInt(2));
                t1.setName(rs1.getString(3));
                t1.setEmail(rs1.getString(4));
                String t2=rs1.getString(5);
                String [] t2Split=t2.split(",");
                for(int i=0;i<t2Split.length;i++){
                    sid.add(Integer.parseInt(t2Split[i]));
                }
                teacherList.add(t1);
                t1.setStudentList(studentList);
            }
            ResultSet rs2=st.executeQuery("select * from student where id='"+id+"'");
            while(rs2.next()) {
                Student s1 = new Student();
                s1.setRollNo(rs2.getInt(1));
                s1.setFees(rs2.getInt(2));
                s1.setAttendance(rs2.getInt(3));
                s1.setName(rs2.getString(4));
                s1.setEmail(rs2.getString(5));
                s1.setBranch(rs2.getString(6));
                studentList.add(s1);
            }
            m1.setTeacherList(teacherList);
        }catch(Exception e){
            System.out.println(e);
        }
        return m1;
    }
    @Override
    public List<Management> selectAllManagement(){
        List<Management> managementList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from management");
            while(rs.next()){
                Management m1=new Management();
                m1.setId(rs.getInt(1));
                m1.setSalary(rs.getInt(2));
                m1.setName(rs.getString(3));
                m1.setEmail(rs.getString(4));
               // m1.setTeacherList(rs.get);
                managementList.add(m1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return managementList;
    }
    @Override
    public Management updateSingleManagement(Management m1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update management set salary='"+m1.getSalary()+"',name='"+m1.getName()+"',email='"+m1.getEmail()+"','"+m1.getTeacherList()+"'where id='"+m1.getId()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingleManagement(m1.getId());
    }
    @Override
    public Boolean deleteSingleManagement(int id){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int ManagementResult=st.executeUpdate("delete from management where id='"+id+"'");
            if(ManagementResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public  Boolean deleteAllManagement(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int count=st.executeUpdate("delete from management");
            if(count>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

    //======================Teacher=============================

    @Override
    public void insertSingleTeacherA(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            //String tids="1,2,3,4";
            //String tids=String.valueOf(t1.getTeacherList().get(0).getId());
            //System.out.println(tids);
//            for(int i=1;i<m1.getTeacherList().size();i++) {
//                tids = tids + "," + m1.getTeacherList().get(i).getId();
//            }
//            System.out.println(tids);
            st.executeUpdate("insert into teacher values('"+t1.getId()+"','"+t1.getSalary()+"','"+t1.getName()+"','"+t1.getEmail()+"')");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public  Teacher selectSingleTeacherA(int id){
        Teacher t1=new Teacher();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();

            List<Integer>tid=new ArrayList<>();
            ResultSet rs=st.executeQuery("select * from teacher where id='"+id+"'");
            while(rs.next()){
                t1.setId(rs.getInt(1));
                t1.setSalary(rs.getInt(2));
                t1.setName(rs.getString(3));
                t1.setEmail(rs.getString(4));
                String tm= rs.getString(5);
                String [] tmSplit = tm.split(",");
                for(int i = 0 ; i < tmSplit.length;i++) {
                    tid.add(Integer.parseInt(tmSplit[i]));
                }
            }
            List<Integer>sid=new ArrayList<>();
            ResultSet rs1=st.executeQuery("select * from student where id='"+id+"'");
            while(rs1.next()){
                Teacher t2=new Teacher();
                t2.setId(rs1.getInt(1));
                t2.setSalary(rs1.getInt(2));
                t2.setName(rs1.getString(3));
                t2.setEmail(rs1.getString(4));
                String s1=rs1.getString(5);
                String [] s1Split=s1.split(",");
                for(int i=0;i<s1Split.length;i++){
                    sid.add(Integer.parseInt(s1Split[i]));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return t1;
    }
    public List<Teacher> selectAllTeacherA(){
        List<Teacher> teacherList=new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from teacher");
            while(rs.next()){
                Teacher t1=new Teacher();
                t1.setId(rs.getInt(1));
                t1.setSalary(rs.getInt(2));
                t1.setName(rs.getString(3));
                t1.setEmail(rs.getString(4));
                // m1.setTeacherList(rs.get);
                teacherList.add(t1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return teacherList;
    }
    @Override
    public Teacher updateSingleTeacherA(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update teacher set salary='"+t1.getSalary()+"',name='"+t1.getName()+"',email='"+t1.getEmail()+"'where id='"+t1.getId()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        return selectSingleTeacherA(t1.getId());
    }
    @Override
    public Boolean deleteSingleTeacherA(int id){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int TeacherResult=st.executeUpdate("delete from teacher where id='"+id+"'");
            if(TeacherResult>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public  Boolean deleteAllTeacherA(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            int count=st.executeUpdate("delete from teacher");
            if(count>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

}

