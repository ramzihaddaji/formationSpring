package com.example.demo.Repository;

import com.example.demo.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*theni 7aja*/
@Repository
public interface DepartmentRepository extends JpaRepository<Department , Long> {
}
