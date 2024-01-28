package com.example.demo.Controller;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.ResponseDepartment;
import com.example.demo.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("formation/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public ResponseEntity<List<ResponseDepartment>> getAllDepartment() {
        List<ResponseDepartment> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @PostMapping("")
    public ResponseEntity<Object> addDepartment(@RequestBody @Valid RequestDepartment request) {
        departmentService.createDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message", "save success"));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDepartment> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping("{id}/user")
    public ResponseEntity<ResponseDepartment> getDepartmentByIdWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentByIdWithUser(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateDepartment(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestDepartment request) {
        departmentService.UpdateDepartment(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonMap("message", "update succes !!!"));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable Long id) {
        Boolean deletedDepartment = departmentService.deleteDepartment(id);
        if (deletedDepartment) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete succes !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("messge", "department not exist"));
    }
}


