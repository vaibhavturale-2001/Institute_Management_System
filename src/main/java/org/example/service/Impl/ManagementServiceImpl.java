package org.example.service.Impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ManagementServiceImpl {

    //==========Teacher=============================================
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

    //=========== Student===============================================
    void insertSingleStudent(Student s1);
    void insertMultipleStudent(List<Student> studentList);
    Student selectSingleStudent(int id);
    List<Student> selectMultipleStudent(List<Integer> ids);
    List<Student> selectAllStudent();
    Student updateSingleStudent(Student s1);
    List<Student> updateMultipleStudent(List<Student> studentList);
    Boolean deleteSingleStudent(int id);
    Boolean deleteMultipleStudent(List<Integer>ids);
    Boolean deleteAllStudent();
}
