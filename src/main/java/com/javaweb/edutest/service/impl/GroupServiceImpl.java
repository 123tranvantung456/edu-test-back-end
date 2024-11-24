package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.GroupRequestDTO;
import com.javaweb.edutest.dto.response.GroupResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.GroupMapper;
import com.javaweb.edutest.model.Group;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.model.User;
import com.javaweb.edutest.repository.GroupRepository;
import com.javaweb.edutest.repository.TestRepository;
import com.javaweb.edutest.repository.UserRepository;
import com.javaweb.edutest.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final TestRepository testRepository;

    @Override
    public List<GroupResponseDTO> getGroups() {
        return groupMapper.toGroupResponseDTOs(groupRepository.findAll());
    }

    @Override
    public GroupResponseDTO getGroup(long groupId) {
        return groupMapper.toGroupResponseDTO(findGroupById(groupId));
    }

    @Override
    public List<GroupResponseDTO> getGroupsOfUser(long userId) {
        return groupMapper.toGroupResponseDTOs(groupRepository.findByOwner_Id(userId));
    }

    @Override
    public long addGroup(GroupRequestDTO groupRequestDTO) {
        Group newGroup = groupMapper.toGroup(groupRequestDTO);
        newGroup = groupRepository.save(newGroup);
        return newGroup.getId();
    }

    @Override
    public void addMembersToGroup(long groupId,  Map<String, List<Long>> request) {
        List<Long> membersIds = request.get("memberIds");
        Group currentGroup = findGroupById(groupId);
        var memberInGroups = currentGroup.getMembers();
        var users = new HashSet<User>();
        membersIds.forEach(membersId -> users.add(findUserById(membersId)));
        currentGroup.getMembers().addAll(users);
        memberInGroups.addAll(users);
    }

    @Override
    public void addTestsToGroup(long groupId, Map<String, List<Long>> request) {
        List<Long> testsIds = request.get("testIds");
        Group currentGroup = findGroupById(groupId);
        var testsInGroups = currentGroup.getTests();
        var tests = new HashSet<Test>();
        testsIds.forEach(testId -> tests.add(findTestById(testId)));
        currentGroup.getTests().addAll(tests);
        testsInGroups.addAll(tests);
    }

    @Override
    public void updateGroup(long groupId, GroupRequestDTO groupRequestDTO) {
        Group currentGroup = findGroupById(groupId);
        groupMapper.updateGroup(currentGroup, groupRequestDTO);
        groupRepository.save(currentGroup);
    }

    @Override
    public void updateMembersInGroup(long groupId, Map<String, List<Long>> request) {
        List<Long> membersIds = request.get("memberIds");
        Group currentGroup = findGroupById(groupId);
        var membersInGroups = currentGroup.getMembers();
        var users = new HashSet<User>();
        membersIds.forEach(membersId -> users.add(findUserById(membersId)));
        currentGroup.setMembers(users);
        membersInGroups.addAll(users);
    }

    @Override
    public void updateTestsInGroup(long groupId, Map<String, List<Long>> request) {
        List<Long> testsIds = request.get("testIds");
        Group currentGroup = findGroupById(groupId);
        var testsInGroups = currentGroup.getTests();
        var tests = new HashSet<Test>();
        testsIds.forEach(testsId -> tests.add(findTestById(testsId)));
        currentGroup.setTests(tests);
        testsInGroups.addAll(tests);
    }

    @Override
    public void deleteGroup(long groupId) {
        groupRepository.deleteById(groupId);
    }

    private Group findGroupById(long groupId) {
        return groupRepository.findById(groupId).orElseThrow(
                () -> new ResourceNotFoundException("group not found with id: " + groupId)
        );
    }

    private User findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("group not found with id: " + userId)
        );
    }

    private Test findTestById(long testId) {
        return testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with id: " + testId)
        );
    }
}
