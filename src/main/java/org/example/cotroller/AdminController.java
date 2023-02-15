package org.example.cotroller;

import org.example.model.Management;
import org.example.model.Teacher;
import org.example.service.Impl.AdminServiceImpl;
import org.example.service.Impl.StudentServiceImpl;
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

    @RequestMapping("/insertSingleManagement")
    @ResponseBody
    void insertSingleManagement(@RequestBody Management m1){
        service.insertSingleManagement(m1);
    }
    @RequestMapping("/insertMultipleManagement")
    @ResponseBody
    void insertMultipleManagement(@RequestBody List<Management> managementList){
        service.insertMultipleManagement(managementList);
    }
    @RequestMapping("/selectSingleManagement")
    @ResponseBody
    Management selectSingleManagement(@RequestParam int id){
        return service.selectSingleManagement(id);
    }
    @RequestMapping("/selectMultipleManagement")
    @ResponseBody
    List<Management> selectMultipleManagement(@RequestParam List<Integer> ids){
        return service.selectMultipleManagement(ids);
    }
    @RequestMapping("selectAllManagement")
    @ResponseBody
    List<Management> selectAllManagement(){
        return service.selectAllManagement();
    }
    @RequestMapping("updateSingleManagement")
    @ResponseBody
    Management updateSingleManagement(@RequestBody Management m1){
        return service.updateSingleManagement(m1);
    }
    @RequestMapping("updateMultipleManagement")
    @ResponseBody
    List<Management> updateMultipleManagement(@RequestBody List<Management> managementList){
        return service.updateMultipleManagement(managementList);
    }
    @RequestMapping("deleteSingleManagement")
    @ResponseBody
    Boolean deleteSingleManagement(@RequestParam int id){
        return service.deleteSingleManagement(id);
    }
    @RequestMapping("deleteMultipleManagement")
    @ResponseBody
    Boolean deleteMultipleManagement(@RequestParam List<Integer>ids){
        return service.deleteMultipleManagement(ids);
    }
    @RequestMapping("deleteAllManagement")
    @ResponseBody
    Boolean deleteAllManagement(){
        return service.deleteAllManagement();
    }

    //======================Teacher===========================


    @RequestMapping("/insertSingleTeacherA")
    @ResponseBody
    void insertSingleTeacherA(@RequestBody Teacher t1){
        service.insertSingleTeacherA(t1);
    }
    @RequestMapping("/insertMultipleTeacherA")
    @ResponseBody
    void insertMultipleTeacherA(@RequestBody List<Teacher> teacherList){
        service.insertMultipleTeacherA(teacherList);
    }
    @RequestMapping("/selectSingleTeacherA")
    @ResponseBody
    Teacher selectSingleTeacherA(@RequestParam int id){
        return service.selectSingleTeacherA(id);
    }
    @RequestMapping("/selectMultipleTeacherA")
    @ResponseBody
    List<Teacher> selectMultipleTeacherA(@RequestParam List<Integer> ids){
        return service.selectMultipleTeacherA(ids);
    }
    @RequestMapping("selectAllTeacherA")
    @ResponseBody
    List<Teacher> selectAllTeacherA(){
        return service.selectAllTeacherA();
    }
    @RequestMapping("updateSingleTeacherA")
    @ResponseBody
    Teacher updateSingleTeacherA(@RequestBody Teacher t1){
        return service.updateSingleTeacherA(t1);
    }
    @RequestMapping("updateMultipleTeacherA")
    @ResponseBody
    List<Teacher> updateMultipleTeacherA(@RequestBody List<Teacher> teacherList){
        return service.updateMultipleTeacherA(teacherList);
    }
    @RequestMapping("deleteSingleTeacherA")
    @ResponseBody
    Boolean deleteSingleTeacherA(@RequestParam int id){
        return service.deleteSingleTeacherA(id);
    }
    @RequestMapping("deleteMultipleTeacherA")
    @ResponseBody
    Boolean deleteMultipleTeacherA(@RequestParam List<Integer>ids){
        return service.deleteMultipleTeacherA(ids);
    }
    @RequestMapping("deleteAllTeacherA")
    @ResponseBody
    Boolean deleteAllTeacherA(){
        return service.deleteAllTeacherA();
    }

}
