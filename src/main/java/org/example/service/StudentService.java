package org.example.service;

import org.example.model.Student;
import org.example.repository.Impl.StudentRepoImpl;
import org.example.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService implements StudentServiceImpl {
    @Autowired
    private StudentRepoImpl repo;
    @Override
    public Student selfUpdate(Student s1){
        return repo.selfUpdate(s1);
    }
}
