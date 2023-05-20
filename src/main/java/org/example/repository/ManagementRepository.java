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
    String url="jdbc:mysql://localhost:3306/testinstitute";
    String userName="root";
    String password="";

    @Override
    public Management managementSelfUpdate(Management m1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            st.executeUpdate("update management set salary='"+m1.getSalary()+"',name='"+m1.getName()+"',email='"+m1.getEmail()+"'where id='"+m1.getId()+"'");
        }catch (Exception e){
            System.out.println(e);
        }
        return m1;
    }
    //=======================Teacher========================
    @Override
    public void insertSingleTeacher(Teacher t1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            String sids=String.valueOf(t1.getStudentList().get(0).getRollNo());
            for(int i=1;i<t1.getStudentList().size();i++){
                sids=sids+","+t1.getStudentList().get(i).getRollNo();
            }
            //List<Student> studentList = new ArrayList<>();
            st.executeUpdate("insert into teacher values('"+t1.getId()+"','"+t1.getSalary()+"','"+t1.getName()+"','"+t1.getEmail()+"','"+sids+"')");

                for(int j=0;j<t1.getStudentList().size();j++){
                    st.executeUpdate("insert into student values('"+t1.getStudentList().get(j).getRollNo()+"','"
                            +t1.getStudentList().get(j).getFees()+"','"
                            +t1.getStudentList().get(j).getAttendance()+"','"
                            +t1.getStudentList().get(j).getName()+"','"
                            +t1.getStudentList().get(j).getEmail()+"','"
                            +t1.getStudentList().get(j).getBranch()+"')");
                }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Teacher selectSingleTeacher(int id){
        Teacher t1=new Teacher();
        try{
            String t2=null;
            List<Student>studentList=new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from teacher where id='"+id+"'");
            List<Integer>sids=new ArrayList<>();
            while (rs.next()) {
                t1.setId(rs.getInt(1));
                t1.setSalary(rs.getInt(2));
                t1.setName(rs.getString(3));
                t1.setEmail(rs.getString(4));
                t1.setStudentList(studentList);
                t2= rs.getString(5);
            }
               // String t2=rs.getString(5);
                String [] t2Split=t2.split(",");
                for(int i=0;i< t2Split.length;i++){
                    sids.add(Integer.parseInt(t2Split[i]));
                }
                for(int i=0;i<sids.size();i++){
                    Student s2=new Student();
                    ResultSet rs1=st.executeQuery("select * from student where rollNo='"+sids.get(i)+"'");
                    while(rs1.next()){
                        s2.setRollNo(rs1.getInt(1));
                        s2.setFees(rs1.getInt(2));
                        s2.setAttendance(rs1.getInt(3));
                        s2.setName(rs1.getString(4));
                        s2.setEmail(rs1.getString(5));
                        s2.setBranch(rs1.getString(6));
                    }
                    studentList.add(s2);
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
            List<Student>studentList=new ArrayList<>();
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
                t1.setStudentList(studentList);
                teacherList.add(t1);
                teacherList.add(selectSingleTeacher(t1.getId()));

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
            st.executeUpdate("update teacher set salary='"+t1.getSalary()+"',"
                    +"name='"+t1.getName()+"',email='"+t1.getEmail()+"'where id='"+t1.getId()+"'");
                   selectSingleTeacher(t1.getId());
                for (int i = 0; i <t1.getStudentList().size(); i++) {
                    st.executeUpdate("update student set fees='" + t1.getStudentList().get(i).getFees()
                            + "',attendance='" + t1.getStudentList().get(i).getAttendance() + "',name='" + t1.getStudentList().get(i).getName()
                            + "',email='" + t1.getStudentList().get(i).getEmail() + "',branch='" + t1.getStudentList().get(i).getBranch()
                            + "' where rollNo='" + t1.getStudentList().get(i).getRollNo() + "'");
                    selectSingleTeacher(t1.getStudentList().get(i).getRollNo());

                }
        }catch(Exception e){
            System.out.println(e);
        }
        return t1;
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
}
