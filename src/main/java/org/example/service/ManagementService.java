package org.example.service;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.ManagementRepoImpl;
import org.example.repository.Impl.TeacherRepoImpl;
import org.example.service.Impl.ManagementServiceImpl;
import org.example.service.Impl.TeacherServiceImpl;
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
    @Override
    public Management managementSelfUpdate(Management m1){
        return repo.managementSelfUpdate(m1);
    }

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
                result=true;
        }
        return result;
    }
    @Override
    public  Boolean deleteAllTeacher(){
        return repo.deleteAllTeacher();
    }

}
