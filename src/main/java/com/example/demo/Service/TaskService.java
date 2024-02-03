package com.example.demo.Service;

import com.example.demo.Dto.*;
import com.example.demo.Entities.Task;
import com.example.demo.Entities.User;

import java.util.List;

public interface TaskService {
    List<ReponseTask> getAllTask();
    boolean deleteTask(Long id);
    void createTask(RequestTask taskrequest);
    Task UpdateTask(Long id, RequestTask requestTask);
    ReponseTask getTaskById(Long id);
}
