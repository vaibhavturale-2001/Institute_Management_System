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
    private TeacherRepoImpl repo;

    @Override
    public Teacher teacherSelfUpdate(Teacher t1){
        return repo.teacherSelfUpdate(t1);
    }

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
