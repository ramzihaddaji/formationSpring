package com.example.demo.ServiceImpl;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.ResponseDepartment;
import com.example.demo.Entities.Department;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository ;

    @Override
    public List<ResponseDepartment> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        List<ResponseDepartment> departmentFormated = new ArrayList<>() ;
        for (Department department:departments){
            ResponseDepartment departmentF = ResponseDepartment.makeDepartment(department);
            departmentFormated.add(departmentF) ;
        }
        return departmentFormated;
    }
    @Override
    public void createDepartment(RequestDepartment departmentRequest){
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .adresse(departmentRequest.getAdresse())
                .status(true)
                .build();
        departmentRepository.save(department);
    }
    @Override
    public ResponseDepartment getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return ResponseDepartment.makeDepartment(department.get());
    }
    @Override
    public ResponseDepartment getDepartmentByIdWithUser(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return ResponseDepartment.makeDepartmentWithUser(department.get());
    }
    @Override
    public Department UpdateDepartment(Long id, RequestDepartment departmentRequest){
        Department department = departmentRepository.findById(id).orElseThrow();
        if (departmentRequest.getName() != null){
            department.setName(departmentRequest.getName());
        }
        if (departmentRequest.getAdresse() != null){
            department.setAdresse(departmentRequest.getAdresse());
        }
        if (departmentRequest.getStatus() != null){
            department.setStatus(departmentRequest.getStatus());
        }
        return departmentRepository.save(department);
    }
    @Override
    public boolean deleteDepartment(Long id){
        if (!departmentRepository.existsById(id)){
            return false ;
        }
        departmentRepository.deleteById(id);
        return true ;
    }
}
