package com.example.demo.ServiceImpl;

import com.example.demo.Dto.*;
import com.example.demo.Entities.Department;
import com.example.demo.Entities.Task;
import com.example.demo.Entities.User;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class taskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder ;
    @Override
    public List<ReponseTask> getAllTask(){
        List<Task> tasks = taskRepository.findAll();
        List<ReponseTask> taskFormated = new ArrayList<>();
        for(Task task : tasks){
            ReponseTask taskk = ReponseTask.makeTask(task);
            taskFormated.add(taskk);
        }
        return taskFormated ;
    }
    @Override
    public void createTask(RequestTask taskRequest){
        User user = userRepository.findById(taskRequest.getUser_id()).orElseThrow();
        Task task = Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .user(user)
                .build();
        taskRepository.save(task);
    }
    @Override
    public boolean deleteTask(Long id){
        if (!taskRepository.existsById(id)){
            return false ;
        }
        taskRepository.deleteById(id);
        return true ;
    }
    @Override
    public Task UpdateTask(Long id, RequestTask requestTask){
        Task task = taskRepository.findById(id).orElseThrow();
        if (requestTask.getTitle() != null){
            task.setTitle(requestTask.getTitle());
        }
        if (requestTask.getDescription() != null){
            task.setDescription(requestTask.getDescription());
        }
        if (requestTask.getUser_id() != null){
            User user = userRepository.getById(requestTask.getUser_id());
            task.setUser(user);
        }
//        if (requestTask.getUser_id() != null){
//            task.setUser(requestTask.getUser_id());
//        }
        return taskRepository.save(task);
    }
    @Override
    public ReponseTask getTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        return ReponseTask.makeTask(task.get());
    }
}
