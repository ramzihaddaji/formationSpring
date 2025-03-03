package com.example.demo.Dto;


import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    Long id ;
    String firstName;
    String lastName ;
    Boolean status;
    int phoneNumber;
    String email ;
    String password ;
    private Instant createdAt ;
    private Instant updatedAt;

    public static ResponseUser makeUser(User user){
        return ResponseUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .status(user.getStatus())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())

                .build();

    }


}
