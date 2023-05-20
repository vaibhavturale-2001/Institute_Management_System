package org.example.service.Impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ManagementServiceImpl {

    Management managementSelfUpdate(Management m1);
    //==========Teacher======================================
    void insertSingleTeacher(Teacher t1);
    void insertMultipleTeacher(List<Teacher> teacherList);
    Teacher selectSingleTeacher(int id);
    List<Teacher> selectMultipleTeacher(List<Integer> ids);
    List<Teacher> selectAllTeacher();
    Teacher updateSingleTeacher(Teacher t1);
    List<Teacher> updateMultipleTeacher(List<Teacher> teacherList);
    Boolean deleteSingleTeacher(int id);
    Boolean deleteMultipleTeacher(List<Integer>ids);
    Boolean deleteAllTeacher();

    //=========== Student=============================

}
