package org.example.repository.Impl;

import org.example.model.Student;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentRepoImpl {
    Student selfUpdate(Student s1);
}
