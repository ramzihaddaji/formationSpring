package com.example.demo.Controller;

import com.example.demo.Dto.*;
import com.example.demo.Service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("formation/task")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService ;


    @GetMapping("")
    public ResponseEntity<List<ReponseTask>> getAllTask() {
        List<ReponseTask> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }


    @PostMapping("")
    public ResponseEntity<Object> createTask(@RequestBody @Valid RequestTask request){
        taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !!")
        );
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id) {
        Boolean deleteTask = taskService.deleteTask(id);
        if (deleteTask) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete succes !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("messge", "task not exist"));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateTask(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestTask request) {
        taskService.UpdateTask(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonMap("message", "update succes !!!"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ReponseTask> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
}

