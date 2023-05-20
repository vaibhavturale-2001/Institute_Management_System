package org.example.repository.Impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;

import java.util.List;

public interface ManagementRepoImpl {

    Management managementSelfUpdate(Management m1);

    //==========Teacher=========================
    void insertSingleTeacher(Teacher t1);
    Teacher selectSingleTeacher(int rollNo);
    List<Teacher> selectAllTeacher();
    Teacher updateSingleTeacher(Teacher t1);
    Boolean deleteSingleTeacher(int rollNo);
    Boolean deleteAllTeacher();
}
