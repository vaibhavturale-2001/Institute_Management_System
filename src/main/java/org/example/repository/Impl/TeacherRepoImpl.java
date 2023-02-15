package org.example.repository.Impl;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

public interface TeacherRepoImpl {

    Teacher teacherSelfUpdate(Teacher t1);
}
