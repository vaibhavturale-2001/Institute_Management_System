package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.TeacherRepoImpl;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherService implements TeacherServiceImpl {
    @Autowired
    private TeacherRepoImpl repoT;

    @Override
    public Teacher teacherSelfUpdate(Teacher t1){
        return repoT.teacherSelfUpdate(t1);
    }

    @Override
    public void insertSingleStudent(Student s1){
        repoT.insertSingleStudent(s1);
    }
    @Override
    public void insertMultipleStudent(List<Student> studentList){
        for(int i=0;i< studentList.size();i++){
            repoT.insertSingleStudent(studentList.get(i));
        }
    }
    @Override
    public Student selectSingleStudent(int rollNo){
        return repoT.selectSingleStudent(rollNo);
    }
    @Override
    public List<Student> selectMultipleStudent(List<Integer>rollNos){
        List<Student> studentList=new ArrayList<>();
        for(int i=0;i< rollNos.size();i++) {
            studentList.add(repoT.selectSingleStudent(rollNos.get(i)));
        }
        return studentList;
    }
    @Override
    public List<Student> selectAllStudent(){
        return repoT.selectAllStudent();
    }
    @Override
    public Student updateSingleStudent(Student s1){
        return repoT.updateSingleStudent(s1);
    }
    @Override
    public List<Student> updateMultipleStudent(List<Student> studentList){
        for(int i=0;i< studentList.size();i++) {
            repoT.updateSingleStudent(studentList.get(i));
        }
        return studentList;
    }
    @Override
    public  Boolean deleteSingleStudent(int rollNo){
        return repoT.deleteSingleStudent(rollNo);
    }
    @Override
    public  Boolean deleteMultipleStudent(List<Integer> rollNos){
        List<Boolean> studentResult=new ArrayList<>();
        Boolean result=false;
        for(int i=0;i<rollNos.size();i++) {
            studentResult.add(repoT.deleteSingleStudent(rollNos.get(i)));
            if(studentResult.get(i).equals(true)){
                result=true;
                System.out.println(true);
            }
            }
//        for(int i=0;i< studentResult.size();i++){
//        if(studentResult.get(i).equals(true)) {
//            result = true;
//            System.out.println(true);
//        }
//        }
        return result;
    }
    @Override
    public  Boolean deleteAllStudent(){
        return repoT.deleteAllStudent();
    }
}
