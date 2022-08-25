package com.example.final_backend_project_rahafalammar.Service;

import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Repository.AuthRepository;
import com.example.final_backend_project_rahafalammar.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> myUser = authRepository.findUsersByUsername(username);
        if(myUser.isEmpty()){
          throw new UsernameNotFoundException("Wrong username or password")  ;
        }
        return myUser.get();
    }
}
