package com.example.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestTask {
    Long id ;
    String title;
    String description;
    Long user_id ;
 //   Long task_id ;
}
