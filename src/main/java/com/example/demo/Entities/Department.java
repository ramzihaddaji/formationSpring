package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.Instant;
import java.util.List;
/*awel 7aja tabda behe*/
@Setter
@Getter
@ToString
/*constuctor*/
@NoArgsConstructor
@AllArgsConstructor
/*-----------------------*/
/*cree un table dans la base de donne*/
@Entity
/*Nom de la table*/
@Table(name="department")
@Builder

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name;
    String adresse;
    Boolean status;
    @CreationTimestamp
    private Instant createdAt ;
    @UpdateTimestamp
    private  Instant updatedAt ;
    @OneToMany(mappedBy = "department")
    private List<User> user ;

}
