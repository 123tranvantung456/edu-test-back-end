package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import java.util.*;

public interface GroupService {
    List<GroupResponseDTO> getGroups();
    GroupResponseDTO getGroup(long groupId);
    List<GroupResponseDTO> getGroupsOfUser();
    long addGroup(GroupRequestDTO groupRequestDTO);
    List<Long> addMembersToGroup(long groupId, List<Long> memberIds);
    List<Long> addTestsToGroup(long groupId, List<Long> testIds);
    void updateGroup(GroupRequestDTO groupRequestDTO);
    List<Long> updateMembersFromGroup(long groupId, List<Long> memberIds);
    List<Long> updateTestsToGroup(long groupId, List<Long> testIds);
    void deleteGroup(long groupId);
}
