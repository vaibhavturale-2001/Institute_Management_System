package org.example.service.Impl;

import org.example.model.Student;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentServiceImpl {
    Student selfUpdate(Student s1);
}
