package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import com.javaweb.edutest.model.Group;
import org.mapstruct.Mapper;

import java.util.*;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupResponseDTO toGroupResponseDTO(Group group);
    List<GroupResponseDTO> toGroupResponseDTOs(List<Group> groups);
    Group toGroup(GroupRequestDTO groupRequestDTO);
}
