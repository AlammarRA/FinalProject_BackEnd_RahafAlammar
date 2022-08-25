package com.example.final_backend_project_rahafalammar.Repository;

import com.example.final_backend_project_rahafalammar.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    Users findUsersByUsername(String username);

    Users findUsersById(Integer id);
}
