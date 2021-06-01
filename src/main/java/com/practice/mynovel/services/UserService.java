package com.practice.mynovel.services;

import com.practice.mynovel.Dto.UserDto;
import com.practice.mynovel.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
   User save(UserDto userDto);
}
