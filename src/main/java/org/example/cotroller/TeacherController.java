package org.example.cotroller;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.Impl.TeacherRepoImpl;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherServiceImpl service;

    @RequestMapping("teacherSelfUpdate")
    @ResponseBody
    Teacher teacherSelfUpdate(@RequestBody Teacher t1){
        return service.teacherSelfUpdate(t1);
    }

    @RequestMapping("/insertSingleStudentT")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student s1){
        service.insertSingleStudent(s1);
    }
    @RequestMapping("/insertMultipleStudentT")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentList){
        service.insertMultipleStudent(studentList);
    }
    @RequestMapping("/selectSingleStudentT")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int id){
        return service.selectSingleStudent(id);
    }
    @RequestMapping("/selectMultipleStudentT")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> ids){
        return service.selectMultipleStudent(ids);
    }
    @RequestMapping("selectAllStudentT")
    @ResponseBody
    List<Student> selectAllStudent(){
        return service.selectAllStudent();
    }
    @RequestMapping("updateSingleStudentT")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student s1){
        return service.updateSingleStudent(s1);
    }
    @RequestMapping("updateMultipleStudentT")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return service.updateMultipleStudent(studentList);
    }
    @RequestMapping("deleteSingleStudentT")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int id){
        return service.deleteSingleStudent(id);
    }
    @RequestMapping("deleteMultipleStudentT")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer>ids){
        return service.deleteMultipleStudent(ids);
    }
    @RequestMapping("deleteAllStudentT")
    @ResponseBody
    Boolean deleteAllStudent(){
        return service.deleteAllStudent();
    }
}
