package com.example.final_backend_project_rahafalammar.Repository;

import com.example.final_backend_project_rahafalammar.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findUsersByUsername(String username);

}
