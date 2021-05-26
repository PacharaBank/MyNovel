package com.practice.mynovel.services;

import com.practice.mynovel.models.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<UserRegistrationDto, Long>, UserDetailsService {

}
