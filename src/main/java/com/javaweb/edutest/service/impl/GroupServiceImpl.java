package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import com.javaweb.edutest.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Override
    public List<GroupResponseDTO> getGroups() {
        return List.of();
    }

    @Override
    public GroupResponseDTO getGroup(long groupId) {
        return null;
    }

    @Override
    public List<GroupResponseDTO> getGroupsOfUser() {
        return List.of();
    }

    @Override
    public long addGroup(GroupRequestDTO groupRequestDTO) {
        return 0;
    }

    @Override
    public List<Long> addMembersToGroup(long groupId, List<Long> memberIds) {
        return List.of();
    }

    @Override
    public List<Long> addTestsToGroup(long groupId, List<Long> testIds) {
        return List.of();
    }

    @Override
    public void updateGroup(GroupRequestDTO groupRequestDTO) {

    }

    @Override
    public List<Long> updateMembersFromGroup(long groupId, List<Long> memberIds) {
        return List.of();
    }

    @Override
    public List<Long> updateTestsToGroup(long groupId, List<Long> testIds) {
        return List.of();
    }

    @Override
    public void deleteGroup(long groupId) {

    }
}
