package com.example.demo.Service;

import com.example.demo.Dto.RequestUser;
import com.example.demo.Dto.RequestUserUpdate;
import com.example.demo.Dto.ResponseUser;
import com.example.demo.Entities.User;
import org.apache.catalina.connector.Request;
import org.apache.coyote.Response;

import java.util.List;

public interface UserService {
    List<ResponseUser> getAllUser();
    boolean deleteUser(Long id);
    void createUser(RequestUser userRequest);
    User updateUser(Long id, RequestUserUpdate UserRequest);
    ResponseUser getUserById(Long id);
}
