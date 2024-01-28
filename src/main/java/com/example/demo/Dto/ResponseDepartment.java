package com.example.demo.Dto;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDepartment {
    Long id ;
    String adresse ;
    String name ;
    Boolean status ;
    private Instant createdAt ;
    private  Instant updatedAt ;
    private List<ResponseUser> user ;

    public static ResponseDepartment makeDepartment(Department department) {
        return ResponseDepartment.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();
    }
    public static ResponseDepartment makeDepartmentWithUser(Department department){
        List<User> users = department.getUser();
        List<ResponseUser> usersFormated = new ArrayList<>() ;
        for (User user : users){
            ResponseUser member = ResponseUser.makeUserWithoutDepartment(user);
            usersFormated.add(member);
        }
        return ResponseDepartment.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .user(usersFormated)
                .build();
    }

}
