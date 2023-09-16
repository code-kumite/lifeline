package com.codekumite.lifeline.service;


import com.codekumite.lifeline.dto.UserDto;
import com.codekumite.lifeline.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}