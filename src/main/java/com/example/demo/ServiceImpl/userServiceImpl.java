package com.example.demo.ServiceImpl;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.RequestUser;
import com.example.demo.Dto.RequestUserUpdate;
import com.example.demo.Dto.ResponseUser;
import com.example.demo.Entities.Department;
import com.example.demo.Entities.User;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder ;
    @Override
    public List<ResponseUser> getAllUser(){
        List<User> users = userRepository.findAll();
        List<ResponseUser> usersFormated = new ArrayList<>();
        for(User user : users){
            ResponseUser member = ResponseUser.makeUser(user);
            usersFormated.add(member);
        }
        return usersFormated ;
    }
    @Override
    public void createUser(RequestUser userRequest){
        Department department = departmentRepository.findById(userRequest.getDepartmentId()).orElseThrow();
        User user = User.builder()
                .lastName(userRequest.getLastName())
                .firstName(userRequest.getFirstName())
                .phoneNumber(userRequest.getPhoneNumber())
                .department(department)
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .status(true)
                .build();
        userRepository.save(user);
    }
    @Override
    public ResponseUser getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return ResponseUser.makeUser(user.get());
    }
    @Override
    public User updateUser(Long id, RequestUserUpdate userReqeust){
        User user = userRepository.findById(id).orElseThrow();
        if (userReqeust.getLastName() != null){
            user.setLastName(userReqeust.getLastName());
        }
        if (userReqeust.getFirstName() != null){
            user.setFirstName(userReqeust.getFirstName());
        }
        if (userReqeust.getStatus() != null){
            user.setStatus(userReqeust.getStatus());
        }
        if (userReqeust.getPhoneNumber() != 0){
            user.setPhoneNumber(userReqeust.getPhoneNumber());
        }
        if (userReqeust.getEmail() != null){
            user.setEmail(userReqeust.getEmail());
        }
        if (userReqeust.getDepartmentId() != null){
            Department department = departmentRepository.getById(userReqeust.getDepartmentId());
            user.setDepartment(department);
        }
        return userRepository.save(user);
    }
    @Override
    public boolean deleteUser(Long id){
        if (!userRepository.existsById(id)){
            return false ;
        }
        userRepository.deleteById(id);
        return true ;
    }
}
