package org.example.service;

import org.example.model.Management;
import org.example.model.Teacher;
import org.example.repository.Impl.AdminRepoImpl;
import org.example.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements AdminServiceImpl {
    @Autowired
    private AdminRepoImpl repo;

    @Override
    public void insertSingleManagement(Management m1) {
        repo.insertSingleManagement(m1);
        //        if(m1.getTeacherList().size()>0)
//            for(int i=0;i<m1.getTeacherList().size();i++){
//
//            }
//                if(m1.getTeacherList().get(i).getStudentList().size()>0){
//                    repo.insertSingleManagement(m1);
//                }
//                else{
//                    repo.insertSingleManagement(m1);

//        else {
//            repo.insertSingleManagement(m1);
//        }
    }

    @Override
    public void insertMultipleManagement(List<Management> managementList) {
        for (int i = 0; i < managementList.size(); i++) {
            repo.insertSingleManagement(managementList.get(i));
        }
    }

    @Override
    public Management selectSingleManagement(@RequestParam int id) {
        return repo.selectSingleManagement(id);
    }

    public List<Management> selectMultipleManagement(List<Integer> ids) {
        List<Management> managementList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            managementList.add(repo.selectSingleManagement(ids.get(i)));
        }
        return managementList;
    }

    @Override
    public List<Management> selectAllManagement() {
        return repo.selectAllManagement();
    }

    @Override
    public Management updateSingleManagement(Management m1) {
        return repo.updateSingleManagement(m1);
    }

    @Override
    public List<Management> updateMultipleManagement(List<Management> managementList) {
        for (int i = 0; i < managementList.size(); i++) {
            repo.updateSingleManagement(managementList.get(i));
        }
        return managementList;
    }

    @Override
    public Boolean deleteSingleManagement(int id) {
        return repo.deleteSingleManagement(id);
    }

    @Override
    public Boolean deleteMultipleManagement(List<Integer> ids) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for (int i = 0; i < ids.size(); i++) {
            resultList.add(repo.deleteSingleManagement(ids.get(i)));
        }
            if (resultList.equals(true)) {
                result = true;
        }
        return result;
    }
    @Override
    public  Boolean deleteAllManagement(){
        return repo.deleteAllManagement();
    }

    //==================Teacher=============================
    @Override
    public void insertSingleTeacherA(Teacher t1) {
        repo.insertSingleTeacherA(t1);
    }

    @Override
    public void insertMultipleTeacherA(List<Teacher> teacherList) {
        for (int i = 0; i < teacherList.size(); i++) {
            repo.insertSingleTeacherA(teacherList.get(i));
        }
    }

    @Override
    public Teacher selectSingleTeacherA(@RequestParam int id) {
        return repo.selectSingleTeacherA(id);
    }

    public List<Teacher> selectMultipleTeacherA(List<Integer> ids) {
        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            teacherList.add(repo.selectSingleTeacherA(ids.get(i)));
        }
        return teacherList;
    }

    @Override
    public List<Teacher> selectAllTeacherA() {
        return repo.selectAllTeacherA();
    }

    @Override
    public Teacher updateSingleTeacherA(Teacher t1) {
        return repo.updateSingleTeacherA(t1);
    }

    @Override
    public List<Teacher> updateMultipleTeacherA(List<Teacher> teacherList) {
        for (int i = 0; i < teacherList.size(); i++) {
            repo.updateSingleTeacherA(teacherList.get(i));
        }
        return teacherList;
    }

    @Override
    public Boolean deleteSingleTeacherA(int id) {
        return repo.deleteSingleTeacherA(id);
    }

    @Override
    public Boolean deleteMultipleTeacherA(List<Integer> ids) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for (int i = 0; i < ids.size(); i++) {
            resultList.add(repo.deleteSingleTeacherA(ids.get(i)));
        }
        if (resultList.equals(true)) {
            result = true;
        }
        return result;
    }
    @Override
    public  Boolean deleteAllTeacherA(){
        return repo.deleteAllTeacherA();
    }
}
