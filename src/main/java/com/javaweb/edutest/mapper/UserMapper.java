package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.UserResponseDTO;
import com.javaweb.edutest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO mapToUserDto(User user);

    User mapToUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> mapToUserDtoList(List<User> userList);

    void mapToUser(@MappingTarget User user, UserRequestDTO userRequestDTO);
}