package org.example.repository.Impl;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeacherRepoImpl {
    Teacher teacherSelfUpdate(Teacher t1);
    void insertSingleStudent(Student s1);
    Student selectSingleStudent(int rollNo);
    List<Student> selectAllStudent();
    Student updateSingleStudent(Student s1);
    Boolean deleteSingleStudent(int rollNo);
    Boolean deleteAllStudent();
}
