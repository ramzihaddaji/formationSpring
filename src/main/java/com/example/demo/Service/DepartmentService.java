package com.example.demo.Service;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.ResponseDepartment;
import com.example.demo.Dto.ResponseUser;
import com.example.demo.Entities.Department;

import java.util.List;

public interface DepartmentService {
    List<ResponseDepartment> getAllDepartment() ;
    boolean deleteDepartment(Long id);
    void createDepartment(RequestDepartment departmentRequest);
    Department UpdateDepartment(Long id, RequestDepartment departmentRequest);
    ResponseDepartment getDepartmentById(Long id);
    ResponseDepartment getDepartmentByIdWithUser(Long id);
}
