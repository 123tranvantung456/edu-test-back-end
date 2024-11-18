package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.UserResponseDTO;
import com.javaweb.edutest.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO mapToUserDto(User user);

    User mapToUser(UserResponseDTO userDto);

    User mapToUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> mapToUserDtoList(List<User> userList);
}
