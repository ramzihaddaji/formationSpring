package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String firstName;
    String lastName ;
    Boolean status;
    int phoneNumber;
    String email ;
    String password ;
    @CreationTimestamp
    private Instant createdAt ;
    @UpdateTimestamp
    private Instant updatedAt;
//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department ;
//
//    @OneToMany(mappedBy="user")
//    private List<Task> tasks ;



}
