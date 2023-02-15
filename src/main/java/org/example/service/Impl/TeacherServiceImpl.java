package org.example.service.Impl;

import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeacherServiceImpl {

    Teacher teacherSelfUpdate(Teacher t1);

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
