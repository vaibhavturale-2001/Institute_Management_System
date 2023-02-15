package org.example.service.Impl;

import org.example.model.Management;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminServiceImpl{
    void insertSingleManagement(Management m1);
    void insertMultipleManagement(List<Management> managementList);
    Management selectSingleManagement(int id);
    List<Management> selectMultipleManagement(List<Integer> ids);
    List<Management> selectAllManagement();
    Management updateSingleManagement(Management m1);
    List<Management> updateMultipleManagement(List<Management> managementList);
    Boolean deleteSingleManagement(int id);
    Boolean deleteMultipleManagement(List<Integer>ids);
    Boolean deleteAllManagement();

    void insertSingleTeacherA(Teacher t1);
    void insertMultipleTeacherA(List<Teacher> managementList);
    Teacher selectSingleTeacherA(int id);
    List<Teacher> selectMultipleTeacherA(List<Integer> ids);
    List<Teacher> selectAllTeacherA();
    Teacher updateSingleTeacherA(Teacher t1);
    List<Teacher> updateMultipleTeacherA(List<Teacher> managementList);
    Boolean deleteSingleTeacherA(int id);
    Boolean deleteMultipleTeacherA(List<Integer>ids);
    Boolean deleteAllTeacherA();
}
