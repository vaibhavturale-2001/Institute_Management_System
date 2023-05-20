package org.example.cotroller;
import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.Impl.ManagementServiceImpl;
import org.example.service.Impl.TeacherServiceImpl;
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
    private ManagementServiceImpl serviceM;
    @RequestMapping("/managementSelfUpdate")
    @ResponseBody
    Management managementSelfUpdate(@RequestBody Management m1){
        return serviceM.managementSelfUpdate(m1);
    }

    //==========Teacher=================================
    @RequestMapping("/insertSingleTeacherM")
    @ResponseBody
    void insertSingleTeacher(@RequestBody Teacher t1){
        serviceM.insertSingleTeacher(t1);
    }
    @RequestMapping("/insertMultipleTeacherM")
    @ResponseBody
    void insertMultipleTeacher(@RequestBody List<Teacher> teacherList){
        serviceM.insertMultipleTeacher(teacherList);
    }
    @RequestMapping("/selectSingleTeacherM")
    @ResponseBody
    Teacher selectSingleTeacher(@RequestParam int id){
        return serviceM.selectSingleTeacher(id);
    }
    @RequestMapping("/selectMultipleTeacherM")
    @ResponseBody
    List<Teacher> selectMultipleTeacher(@RequestParam List<Integer> ids){
        return serviceM.selectMultipleTeacher(ids);
    }
    @RequestMapping("selectAllTeacherM")
    @ResponseBody
    List<Teacher> selectAllTeacher(){
        return serviceM.selectAllTeacher();
    }
    @RequestMapping("updateSingleTeacherM")
    @ResponseBody
    Teacher updateSingleTeacher(@RequestBody Teacher t1){
        return serviceM.updateSingleTeacher(t1);
    }
    @RequestMapping("updateMultipleTeacherM")
    @ResponseBody
    List<Teacher> updateMultipleTeacher(@RequestBody List<Teacher> teacherList){
        return serviceM.updateMultipleTeacher(teacherList);
    }
    @RequestMapping("deleteSingleTeacherM")
    @ResponseBody
    Boolean deleteSingleTeacher(@RequestParam int id){
        return serviceM.deleteSingleTeacher(id);
    }
    @RequestMapping("deleteMultipleTeacherM")
    @ResponseBody
    Boolean deleteMultipleTeacher(@RequestParam List<Integer>ids){
        return serviceM.deleteMultipleTeacher(ids);
    }
    @RequestMapping("deleteAllTeacherM")
    @ResponseBody
    Boolean deleteAllTeacher(){
        return serviceM.deleteAllTeacher();
    }

    //================Students=================================
    @Autowired
    private TeacherServiceImpl serviceT;

    @RequestMapping("/insertSingleStudentM")
    @ResponseBody
    void insertSingleStudent(@RequestBody Student s1){
        serviceT.insertSingleStudent(s1);
    }
    @RequestMapping("/insertMultipleStudentM")
    @ResponseBody
    void insertMultipleStudent(@RequestBody List<Student> studentList){
        serviceT.insertMultipleStudent(studentList);
    }
    @RequestMapping("/selectSingleStudentM")
    @ResponseBody
    Student selectSingleStudent(@RequestParam int rollNo){
        return serviceT.selectSingleStudent(rollNo);
    }
    @RequestMapping("/selectMultipleStudentM")
    @ResponseBody
    List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos){
        return serviceT.selectMultipleStudent(rollNos);
    }
    @RequestMapping("selectAllStudentM")
    @ResponseBody
    List<Student> selectAllStudent(){
        return serviceT.selectAllStudent();
    }
    @RequestMapping("updateSingleStudentM")
    @ResponseBody
    Student updateSingleStudent(@RequestBody Student s1){
        return serviceT.updateSingleStudent(s1);
    }
    @RequestMapping("updateMultipleStudentM")
    @ResponseBody
    List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
        return serviceT.updateMultipleStudent(studentList);
    }
    @RequestMapping("deleteSingleStudentM")
    @ResponseBody
    Boolean deleteSingleStudent(@RequestParam int rollNo){
        return serviceT.deleteSingleStudent(rollNo);
    }
    @RequestMapping("deleteMultipleStudentM")
    @ResponseBody
    Boolean deleteMultipleStudent(@RequestParam List<Integer>rollNos){
        return serviceT.deleteMultipleStudent(rollNos);
    }
    @RequestMapping("deleteAllStudentM")
    @ResponseBody
    Boolean deleteAllStudent(){
        return serviceT.deleteAllStudent();
    }
}
