package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import java.util.*;

public interface GroupService {
    List<GroupResponseDTO> getGroups();
    GroupResponseDTO getGroup(long groupId);
    List<GroupResponseDTO> getGroupsOfUser(long userId);
    long addGroup(GroupRequestDTO groupRequestDTO);
    List<Long> addMembersToGroup(long groupId, Map<String, List<Long> > request);
    List<Long> addTestsToGroup(long groupId, Map<String, List<Long> > request);
    void updateGroup(long groupId, GroupRequestDTO groupRequestDTO);
    List<Long> updateMembersInGroup(long groupId, Map<String, List<Long> > request);
    List<Long> updateTestsInGroup(long groupId, Map<String, List<Long> > request);
    void deleteGroup(long groupId);
}
