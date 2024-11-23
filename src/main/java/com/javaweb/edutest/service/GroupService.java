package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import java.util.*;

public interface GroupService {
    List<GroupResponseDTO> getGroups();
    GroupResponseDTO getGroup(long groupId);
    List<GroupResponseDTO> getGroupsOfUser(long userId);
    long addGroup(GroupRequestDTO groupRequestDTO);
    void addMembersToGroup(long groupId, Map<String, List<Long> > request);
    void addTestsToGroup(long groupId, Map<String, List<Long> > request);
    void updateGroup(long groupId, GroupRequestDTO groupRequestDTO);
    void updateMembersInGroup(long groupId, Map<String, List<Long> > request);
    void updateTestsInGroup(long groupId, Map<String, List<Long> > request);
    void deleteGroup(long groupId);
}
