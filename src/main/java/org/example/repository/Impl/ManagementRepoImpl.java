package org.example.repository.Impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;

import java.util.List;

public interface ManagementRepoImpl {

    //==========Teacher=========================
    void insertSingleTeacher(Teacher t1);
    Teacher selectSingleTeacher(int id);
    List<Teacher> selectAllTeacher();
    Teacher updateSingleTeacher(Teacher t1);
    Boolean deleteSingleTeacher(int id);
    Boolean deleteAllTeacher();

    //===========Students========================

    void insertSingleStudent(Student s1);
    Student selectSingleStudent(int id);
    List<Student> selectAllStudent();
    Student updateSingleStudent(Student s1);
    Boolean deleteSingleStudent(int id);
    Boolean deleteAllStudent();
}
