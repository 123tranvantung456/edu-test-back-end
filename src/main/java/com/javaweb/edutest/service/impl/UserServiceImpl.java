package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.UserResponseDTO;
import com.javaweb.edutest.mapper.UserMapper;
import com.javaweb.edutest.model.User;
import com.javaweb.edutest.repository.UserRepository;
import com.javaweb.edutest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getUsers() {
        return userMapper.mapToUserDtoList(userRepository.findAll());
    }

    @Override
    public UserResponseDTO getUser(long id) {
        return userMapper.mapToUserDto(findUserById(id));
    }

    @Override
    public long addUser(UserRequestDTO userRequestDTO) {
        User newUser = userMapper.mapToUser(userRequestDTO);
        userRepository.save(newUser);
        return newUser.getId();
    }

    @Override
    public void updateStatus() {

    }

    @Override
    public void updateUser(long userId, UserRequestDTO userRequestDTO) {
        User userCurrent = findUserById(userId);
        userMapper.mapToUser(userCurrent, userRequestDTO);
        userRepository.save(userCurrent);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    private User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
    }
}