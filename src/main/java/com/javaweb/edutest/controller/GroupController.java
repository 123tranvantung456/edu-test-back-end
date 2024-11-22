package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.response.GroupResponseDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseData<?> getGroups() {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{groupId}")
    public ResponseData<?> getGroup(@PathVariable long groupId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseData<?> getGroupOfUser(@PathVariable long userId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<?> addGroup(@RequestBody GroupResponseDTO groupResponseDTO) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("{groupId}/member")
    public ResponseData<?> addMemberToGroup(@PathVariable long groupId, @RequestBody Map<String, List<Long>> request){
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("{groupId}/test")
    public ResponseData<?> addTestToGroup(@PathVariable long groupId, @RequestBody Map<String, List<Long>> request) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("{groupId}/member")
    public ResponseData<?> updateMemberToGroup(@PathVariable long groupId, @RequestBody Map<String, List<Long>> request){
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("{groupId}/test")
    public ResponseData<?> updateTestToGroup(@PathVariable long groupId, @RequestBody Map<String, List<Long>> request) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{groupId}")
    public ResponseData<?> updateGroup(@PathVariable long groupId, @RequestBody GroupResponseDTO groupResponseDTO) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{groupId}")
    public ResponseData<?> deleteGroup(@PathVariable long groupId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}