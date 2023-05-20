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
    private TeacherServiceImpl serviceT;
    @RequestMapping("teacherSelfUpdate")
    @ResponseBody
    Teacher teacherSelfUpdate(@RequestBody Teacher t1){
        return serviceT.teacherSelfUpdate(t1);
    }

    @RequestMapping("/insertSingleStudentT")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student s1){
        serviceT.insertSingleStudent(s1);
    }
    @RequestMapping("/insertMultipleStudentT")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentList){
        serviceT.insertMultipleStudent(studentList);
    }
    @RequestMapping("/selectSingleStudentT")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int rollNo){
        return serviceT.selectSingleStudent(rollNo);
    }
    @RequestMapping("/selectMultipleStudentT")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos){
        return serviceT.selectMultipleStudent(rollNos);
    }
    @RequestMapping("selectAllStudentT")
    @ResponseBody
    List<Student> selectAllStudent(){
        return serviceT.selectAllStudent();
    }
    @RequestMapping("updateSingleStudentT")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student s1){
        return serviceT.updateSingleStudent(s1);
    }
    @RequestMapping("updateMultipleStudentT")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return serviceT.updateMultipleStudent(studentList);
    }
    @RequestMapping("deleteSingleStudentT")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int rollNo){
        return serviceT.deleteSingleStudent(rollNo);
    }
    @RequestMapping("deleteMultipleStudentT")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer>rollNos){
        return serviceT.deleteMultipleStudent(rollNos);
    }
    @RequestMapping("deleteAllStudentT")
    @ResponseBody
    Boolean deleteAllStudent(){
        return serviceT.deleteAllStudent();
    }
}
