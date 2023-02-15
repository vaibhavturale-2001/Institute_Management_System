package org.example.repository.Impl;

import org.example.model.Management;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminRepoImpl {
    void insertSingleManagement(Management m1);
    Management selectSingleManagement(int id);
    List<Management> selectAllManagement();
    Management updateSingleManagement(Management m1);
    Boolean deleteSingleManagement(int id);
    Boolean deleteAllManagement();


    void insertSingleTeacherA(Teacher t1);
    Teacher selectSingleTeacherA(int id);
    List<Teacher> selectAllTeacherA();
    Teacher updateSingleTeacherA(Teacher m1);
    Boolean deleteSingleTeacherA(int id);
    Boolean deleteAllTeacherA();
}
