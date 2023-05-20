package org.example.cotroller;

import org.example.model.Student;
import org.example.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl service;
    @RequestMapping("/studentSelfUpdate")
    @ResponseBody
    Student selfUpdate(@RequestBody Student s1){
        return service.selfUpdate(s1);
    }
}
