package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String title ;
    String description ;
    @CreationTimestamp
    private Instant createdAt ;
    @UpdateTimestamp
    private Instant updatedAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;


}
