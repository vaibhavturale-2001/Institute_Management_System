package org.example.cotroller;

import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.Impl.AdminServiceImpl;
import org.example.service.Impl.ManagementServiceImpl;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController{
    @Autowired
    private AdminServiceImpl service;

    @RequestMapping("/insertSingleManagementA")
    @ResponseBody
    void insertSingleManagement(@RequestBody Management m1){
        service.insertSingleManagement(m1);
    }
    @RequestMapping("/insertMultipleManagementA")
    @ResponseBody
    void insertMultipleManagement(@RequestBody List<Management> managementList){
        service.insertMultipleManagement(managementList);
    }
    @RequestMapping("/selectSingleManagementA")
    @ResponseBody
    Management selectSingleManagement(@RequestParam int id){
        return service.selectSingleManagement(id);
    }
    @RequestMapping("/selectMultipleManagementA")
    @ResponseBody
    List<Management> selectMultipleManagement(@RequestParam List<Integer> ids){
        return service.selectMultipleManagement(ids);
    }
    @RequestMapping("selectAllManagementA")
    @ResponseBody
    List<Management> selectAllManagement(){
        return service.selectAllManagement();
    }
    @RequestMapping("updateSingleManagementA")
    @ResponseBody
    Management updateSingleManagement(@RequestBody Management m1){
        return service.updateSingleManagement(m1);
    }
    @RequestMapping("updateMultipleManagementA")
    @ResponseBody
    List<Management> updateMultipleManagement(@RequestBody List<Management> managementList){
        return service.updateMultipleManagement(managementList);
    }
    @RequestMapping("deleteSingleManagementA")
    @ResponseBody
    Boolean deleteSingleManagement(@RequestParam int id){
        return service.deleteSingleManagement(id);
    }
    @RequestMapping("deleteMultipleManagementA")
    @ResponseBody
    Boolean deleteMultipleManagement(@RequestParam List<Integer>ids){
        return service.deleteMultipleManagement(ids);
    }
    @RequestMapping("deleteAllManagementA")
    @ResponseBody
    Boolean deleteAllManagement(){
        return service.deleteAllManagement();
    }

    //======================Teacher=========================
    @Autowired
    private ManagementServiceImpl serviceM;
    @RequestMapping("/insertSingleTeacherA")
    @ResponseBody
    void insertSingleTeacherA(@RequestBody Teacher t1){
        serviceM.insertSingleTeacher(t1);
    }
    @RequestMapping("/insertMultipleTeacherA")
    @ResponseBody
    void insertMultipleTeacherA(@RequestBody List<Teacher> teacherList){
        serviceM.insertMultipleTeacher(teacherList);
    }
    @RequestMapping("/selectSingleTeacherA")
    @ResponseBody
    Teacher selectSingleTeacherA(@RequestParam int id){
        return serviceM.selectSingleTeacher(id);
    }
    @RequestMapping("/selectMultipleTeacherA")
    @ResponseBody
    List<Teacher> selectMultipleTeacherA(@RequestParam List<Integer> ids){
        return serviceM.selectMultipleTeacher(ids);
    }
    @RequestMapping("selectAllTeacherA")
    @ResponseBody
    List<Teacher> selectAllTeacherA(){
        return serviceM.selectAllTeacher();
    }
    @RequestMapping("updateSingleTeacherA")
    @ResponseBody
    Teacher updateSingleTeacherA(@RequestBody Teacher t1){
        return serviceM.updateSingleTeacher(t1);
    }
    @RequestMapping("updateMultipleTeacherA")
    @ResponseBody
    List<Teacher> updateMultipleTeacherA(@RequestBody List<Teacher> teacherList){
        return serviceM.updateMultipleTeacher(teacherList);
    }
    @RequestMapping("deleteSingleTeacherA")
    @ResponseBody
    Boolean deleteSingleTeacherA(@RequestParam int id){
        return serviceM.deleteSingleTeacher(id);
    }
    @RequestMapping("deleteMultipleTeacherA")
    @ResponseBody
    Boolean deleteMultipleTeacherA(@RequestParam List<Integer>ids){
        return serviceM.deleteMultipleTeacher(ids);
    }
    @RequestMapping("deleteAllTeacherA")
    @ResponseBody
    Boolean deleteAllTeacher(){
        return serviceM.deleteAllTeacher();
    }

//======================Student======================
        @Autowired
        private TeacherServiceImpl serviceT;

        @RequestMapping("/insertSingleStudentA")
        @ResponseBody
        void insertSingleStudent(@RequestBody Student s1){
            serviceT.insertSingleStudent(s1);
        }
        @RequestMapping("/insertMultipleStudentA")
        @ResponseBody
        void insertMultipleStudent(@RequestBody List<Student> studentList){
            serviceT.insertMultipleStudent(studentList);
        }
        @RequestMapping("/selectSingleStudentA")
        @ResponseBody
        Student selectSingleStudent(@RequestParam int rollNo){
            return serviceT.selectSingleStudent(rollNo);
        }
        @RequestMapping("/selectMultipleStudentA")
        @ResponseBody
        List<Student> selectMultipleStudent(@RequestParam List<Integer> rollNos){
            return serviceT.selectMultipleStudent(rollNos);
        }
        @RequestMapping("selectAllStudentA")
        @ResponseBody
        List<Student> selectAllStudent(){
            return serviceT.selectAllStudent();
        }
        @RequestMapping("updateSingleStudentA")
        @ResponseBody
        Student updateSingleStudent(@RequestBody Student s1){
            return serviceT.updateSingleStudent(s1);
        }
        @RequestMapping("updateMultipleStudentA")
        @ResponseBody
        List<Student> updateMultipleStudent(@RequestBody List<Student> studentList){
            return serviceT.updateMultipleStudent(studentList);
        }
        @RequestMapping("deleteSingleStudentA")
        @ResponseBody
        Boolean deleteSingleStudent(@RequestParam int rollNo){
            return serviceT.deleteSingleStudent(rollNo);
        }
        @RequestMapping("deleteMultipleStudentA")
        @ResponseBody
        Boolean deleteMultipleStudent(@RequestParam List<Integer>rollNos){
            return serviceT.deleteMultipleStudent(rollNos);
        }
        @RequestMapping("deleteAllStudentA")
        @ResponseBody
        Boolean deleteAllStudent(){
            return serviceT.deleteAllStudent();
        }

}
