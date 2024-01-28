package com.example.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserUpdate {
    Long id ;
    String firstName;
    String lastName;
    Boolean status;
    int phoneNumber ;
    @NotNull(message = "email required")
    @Email
    String email ;
    Long departmentId;
}
