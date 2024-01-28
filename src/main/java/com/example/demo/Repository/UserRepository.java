package com.example.demo.Repository;

import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*user howa el 7aja ele besh ne5dem behe o type emta3 el id el primary key*/
public interface UserRepository extends JpaRepository<User,Long> {
}
