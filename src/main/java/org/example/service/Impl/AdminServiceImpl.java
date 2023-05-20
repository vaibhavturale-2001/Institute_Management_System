package org.example.service.Impl;

import org.example.model.Management;
import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminServiceImpl{
    void insertSingleManagement(Management m1);
    void insertMultipleManagement(List<Management> managementList);
    Management selectSingleManagement(int id);
    List<Management> selectMultipleManagement(List<Integer> ids);
    List<Management> selectAllManagement();
    Management updateSingleManagement(Management m1);
    List<Management> updateMultipleManagement(List<Management> managementList);
    Boolean deleteSingleManagement(int id);
    Boolean deleteMultipleManagement(List<Integer>ids);
    Boolean deleteAllManagement();
}
