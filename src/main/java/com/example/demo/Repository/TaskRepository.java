package com.example.demo.Repository;

import com.example.demo.Entities.Task;
import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
