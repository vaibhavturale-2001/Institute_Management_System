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
//            System.out.println(tids);
            st.executeUpdate("insert into management values('"+m1.getId()+"','" +m1.getSalary()+"','"+m1.getName()+"','" +m1.getEmail()+"','"+tids+"')");

            for(int i=0;i<m1.getTeacherList().size();i++){
                String sids = String.valueOf(m1.getTeacherList().get(i).getStudentList().get(0).getRollNo());
                for(int j=1;j<m1.getTeacherList().get(i).getStudentList().size();j++){
                    sids=sids+","+m1.getTeacherList().get(i).getStudentList().get(j).getRollNo();
                }
//                System.out.println(sids);
                st.executeUpdate("insert into teacher values('" + m1.getTeacherList().get(i).getId() + "','"
                        +m1.getTeacherList().get(i).getSalary()+"','"
                        + m1.getTeacherList().get(i).getName() + "','"
                        + m1.getTeacherList().get(i).getEmail() + "','"+sids+"')");
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
            String m2=null;
            List<Teacher>teacherList=new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from management where id='"+id+"'");
            while(rs.next()){
                m1.setId(rs.getInt(1));
                m1.setSalary(rs.getInt(2));
                m1.setName(rs.getString(3));
                m1.setEmail(rs.getString(4));
                m1.setTeacherList(teacherList);
                m2=rs.getString(5);
            }
            List<Integer>tid=new ArrayList<>();
            String [] m2Split = m2.split(",");
            for(int i = 0 ; i < m2Split.length;i++) {
                    tid.add(Integer.parseInt(m2Split[i]));
                }

            List<Student> studentList=new ArrayList<>();
            String t2="";
            for (int i=0;i<tid.size();i++){
                Teacher t1=new Teacher();
                ResultSet rs1=st.executeQuery("select * from teacher where id='"+tid.get(i)+"'");
                while(rs1.next()) {
                    t1.setId(rs1.getInt(1));
                    t1.setSalary(rs1.getInt(2));
                    t1.setName(rs1.getString(3));
                    t1.setEmail(rs1.getString(4));
                    t2 = rs1.getString(5);
                    t1.setStudentList(studentList);
                }
                    teacherList.add(t1);
            }
            List<Integer>sid=new ArrayList<>();
                    String [] t2Split=t2.split(",");
                    for(int j=0;j<t2Split.length;j++){
                        sid.add(Integer.parseInt(t2Split[j]));
                    }
           for (int k=0;k<sid.size();k++) {
               Student s1 = new Student();
               ResultSet rs2 = st.executeQuery("select * from student where rollNo='" +sid.get(k)+ "'");
               while (rs2.next()) {
                   s1.setRollNo(rs2.getInt(1));
                   s1.setFees(rs2.getInt(2));
                   s1.setAttendance(rs2.getInt(3));
                   s1.setName(rs2.getString(4));
                   s1.setEmail(rs2.getString(5));
                   s1.setBranch(rs2.getString(6));
               }
               studentList.add(s1);
           }
        }catch(Exception e){
            System.out.println(e);
        }
        return m1;
    }
    @Override
    public List<Management> selectAllManagement(){
        List<Management> managementList=new ArrayList<>();
        try{
            List<Teacher>teacherList=new ArrayList<>();
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
                m1.setTeacherList(teacherList);
                managementList.add(m1);
                managementList.add(selectSingleManagement(m1.getId()));
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
            st.executeUpdate("update management set salary='"+m1.getSalary()+"',name='"+m1.getName()+"',email='"+m1.getEmail()+"'where id='"+m1.getId()+"'");
            selectSingleManagement(m1.getId());
            for (int i=0;i<m1.getTeacherList().size();i++) {
                st.executeUpdate("update teacher set salary='" + m1.getTeacherList().get(i).getSalary() + "',name='" + m1.getTeacherList().get(i).getName() + "',email='" + m1.getTeacherList().get(i).getEmail() + "'where id='" + m1.getTeacherList().get(i).getId() + "'");
                selectSingleManagement(m1.getTeacherList().get(i).getId());
            }
            for (int j=0;j<m1.getTeacherList().size();j++){
                for (int k=0;k<m1.getTeacherList().get(j).getStudentList().size();k++){
                    st.executeUpdate("update student set fees='"+m1.getTeacherList().get(j).getStudentList().get(k).getFees() +"',attendance='"
                            +m1.getTeacherList().get(j).getStudentList().get(k).getAttendance()+"',name='"
                            +m1.getTeacherList().get(j).getStudentList().get(k).getName()+"',email='"
                            +m1.getTeacherList().get(j).getStudentList().get(k).getEmail()+"',branch='"
                            +m1.getTeacherList().get(j).getStudentList().get(k).getBranch()+"' where rollNo='"
                            +m1.getTeacherList().get(j).getStudentList().get(k).getRollNo()+"'");
                    //selectmanagementsingle(management.getId());
                }
                selectSingleManagement(m1.getTeacherList().get(j).getStudentList().get(j).getRollNo());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return m1;
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
}

