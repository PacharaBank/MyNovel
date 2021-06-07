package com.practice.mynovel.services.implement;

import com.practice.mynovel.dto.UserDto;
import com.practice.mynovel.models.Role;
import com.practice.mynovel.models.User;
import com.practice.mynovel.respositories.UserRepository;
import com.practice.mynovel.securities.CustomUserDetails;
import com.practice.mynovel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDto userDto) {
       User user = new User();
       user.setFirstName(userDto.getFirstName());
       user.setLastName(userDto.getLastName());
       user.setEmail(userDto.getEmail());
       user.setRolesList(Arrays.asList(new Role("ROLE_USER")));
       user.setPassword(passwordEncoder.encode(userDto.getPassword()));
       return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loading user process");
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new CustomUserDetails(user);
    }

}
