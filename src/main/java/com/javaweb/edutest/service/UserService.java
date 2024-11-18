package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getUsers();
    UserResponseDTO getUser(long id);
    long addUser(UserRequestDTO user);
    void updateUser(long userId, UserRequestDTO user);
    void deleteUser(long userId);
}
