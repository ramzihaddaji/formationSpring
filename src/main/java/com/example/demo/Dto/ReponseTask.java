package com.example.demo.Dto;


import com.example.demo.Entities.Task;
import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTask {
    Long id;
    String title;
    String description;
    private Instant createdAt;
    private Instant updatedAt;
    private ResponseUser user;


    public static ReponseTask makeTask(Task task) {
        return ReponseTask.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .user(ResponseUser.makeUser(task.getUser()))
                .build();
    }
}
