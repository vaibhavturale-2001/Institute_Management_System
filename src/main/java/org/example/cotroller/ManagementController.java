package org.example.cotroller;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.Impl.ManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManagementController {
    @Autowired
    private ManagementServiceImpl service;

    //==========Teacher=================================


    @RequestMapping("/insertSingleTeacher")
    @ResponseBody
    void insertSingleTeacher(@RequestBody Teacher t1){
        service.insertSingleTeacher(t1);
    }
    @RequestMapping("/insertMultipleTeacher")
    @ResponseBody
    void insertMultipleTeacher(@RequestBody List<Teacher> teacherList){
        service.insertMultipleTeacher(teacherList);
    }
    @RequestMapping("/selectSingleTeacher")
    @ResponseBody
    Teacher selectSingleTeacher(@RequestParam int id){
        return service.selectSingleTeacher(id);
    }
    @RequestMapping("/selectMultipleTeacher")
    @ResponseBody
    List<Teacher> selectMultipleTeacher(@RequestParam List<Integer> ids){
        return service.selectMultipleTeacher(ids);
    }
    @RequestMapping("selectAllTeacher")
    @ResponseBody
    List<Teacher> selectAllTeacher(){
        return service.selectAllTeacher();
    }
    @RequestMapping("updateSingleTeacher")
    @ResponseBody
    Teacher updateSingleTeacher(@RequestBody Teacher t1){
        return service.updateSingleTeacher(t1);
    }
    @RequestMapping("updateMultipleTeacher")
    @ResponseBody
    List<Teacher> updateMultipleTeacher(@RequestBody List<Teacher> teacherList){
        return service.updateMultipleTeacher(teacherList);
    }
    @RequestMapping("deleteSingleTeacher")
    @ResponseBody
    Boolean deleteSingleTeacher(@RequestParam int id){
        return service.deleteSingleTeacher(id);
    }
    @RequestMapping("deleteMultipleTeacher")
    @ResponseBody
    Boolean deleteMultipleTeacher(@RequestParam List<Integer>ids){
        return service.deleteMultipleTeacher(ids);
    }
    @RequestMapping("deleteAllTeacher")
    @ResponseBody
    Boolean deleteAllTeacher(){
        return service.deleteAllTeacher();
    }

    //================Students====================================================

    @RequestMapping("/insertSingleStudent")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student s1){
        service.insertSingleStudent(s1);
    }
    @RequestMapping("/insertMultipleStudent")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentList){
        service.insertMultipleStudent(studentList);
    }
    @RequestMapping("/selectSingleStudent")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int id){
        return service.selectSingleStudent(id);
    }
    @RequestMapping("/selectMultipleStudent")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> ids){
        return service.selectMultipleStudent(ids);
    }
    @RequestMapping("selectAllStudent")
    @ResponseBody
    List<Student> selectAllStudent(){
        return service.selectAllStudent();
    }
    @RequestMapping("updateSingleStudent")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student s1){
        return service.updateSingleStudent(s1);
    }
    @RequestMapping("updateMultipleStudent")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return service.updateMultipleStudent(studentList);
    }
    @RequestMapping("deleteSingleStudent")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int id){
        return service.deleteSingleStudent(id);
    }
    @RequestMapping("deleteMultipleStudent")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer>ids){
        return service.deleteMultipleStudent(ids);
    }
    @RequestMapping("deleteAllStudent")
    @ResponseBody
    Boolean deleteAllStudent(){
        return service.deleteAllStudent();
    }


}
