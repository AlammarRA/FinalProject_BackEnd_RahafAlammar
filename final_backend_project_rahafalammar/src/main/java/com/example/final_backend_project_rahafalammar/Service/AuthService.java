package com.example.final_backend_project_rahafalammar.Service;

import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void register(Users user){
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authRepository.save(user);
    }
}
