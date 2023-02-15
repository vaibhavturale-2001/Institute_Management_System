package org.example.service;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.ManagementRepoImpl;
import org.example.service.Impl.ManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService implements ManagementServiceImpl {
    @Autowired
    private ManagementRepoImpl repo;

    //==========Teacher=====================

    @Override
    public void insertSingleTeacher(Teacher t1){
        repo.insertSingleTeacher(t1);
    }
    @Override
    public void insertMultipleTeacher(List<Teacher> teacherList){
        for(int i=0;i< teacherList.size();i++) {
            repo.insertSingleTeacher(teacherList.get(i));
        }
    }
    @Override
    public Teacher selectSingleTeacher(int id){
       return repo.selectSingleTeacher(id);
    }
    @Override
    public List<Teacher> selectMultipleTeacher(List<Integer> ids){
        List<Teacher> teacherList=new ArrayList<>();
        for(int i=0;i< ids.size();i++) {
            teacherList.add(repo.selectSingleTeacher(ids.get(i)));
        }
        return teacherList;
    }
    @Override
    public List<Teacher> selectAllTeacher(){
        return repo.selectAllTeacher();
    }
    @Override
    public Teacher updateSingleTeacher(Teacher t1){
        return repo.updateSingleTeacher(t1);
    }
    @Override
    public List<Teacher> updateMultipleTeacher(List<Teacher> teacherList){
        for(int i=0;i< teacherList.size();i++) {
            repo.updateSingleTeacher(teacherList.get(i));
        }
        return teacherList;
    }
    @Override
    public  Boolean deleteSingleTeacher(int id){
        return repo.deleteSingleTeacher(id);
    }
    @Override
    public  Boolean deleteMultipleTeacher(List<Integer> ids){
        List<Boolean> teacherResult=new ArrayList<>();
        Boolean result=false;
        for(int i=0;i<ids.size();i++) {
            teacherResult.add(repo.deleteSingleTeacher(ids.get(i)));
        }
        if(teacherResult.equals(true)){
            result=true;
        }
        return result;
    }
    @Override
    public  Boolean deleteAllTeacher(){
        return repo.deleteAllTeacher();
    }

    //===============Student============================================

    @Override
    public void insertSingleStudent(Student s1){
        repo.insertSingleStudent(s1);
    }
    @Override
    public void insertMultipleStudent(List<Student> studentList){
        for(int i=0;i< studentList.size();i++) {
            repo.insertSingleStudent(studentList.get(i));
        }
    }
    @Override
    public Student selectSingleStudent(int id){
        return repo.selectSingleStudent(id);
    }
    @Override
    public List<Student> selectMultipleStudent(List<Integer> ids){
        List<Student> studentList=new ArrayList<>();
        for(int i=0;i< ids.size();i++) {
            studentList.add(repo.selectSingleStudent(ids.get(i)));
        }
        return studentList;
    }
    @Override
    public List<Student> selectAllStudent(){
        return repo.selectAllStudent();
    }
    @Override
    public Student updateSingleStudent(Student s1){
        return repo.updateSingleStudent(s1);
    }
    @Override
    public List<Student> updateMultipleStudent(List<Student> studentList){
        for(int i=0;i< studentList.size();i++) {
            repo.updateSingleStudent(studentList.get(i));
        }
        return studentList;
    }
    @Override
    public  Boolean deleteSingleStudent(int id){
        return repo.deleteSingleStudent(id);
    }
    @Override
    public  Boolean deleteMultipleStudent(List<Integer> ids){
        List<Boolean> studentResult=new ArrayList<>();
        Boolean result=false;
        for(int i=0;i<ids.size();i++) {
            studentResult.add(repo.deleteSingleStudent(ids.get(i)));
        }
        if(studentResult.equals(true)){
            result=true;
        }
        return result;
    }
    @Override
    public  Boolean deleteAllStudent(){
        return repo.deleteAllStudent();
    }

}
