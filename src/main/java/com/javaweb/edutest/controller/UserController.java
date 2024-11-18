package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.dto.response.UserResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseData<List<UserResponseDTO>> getUsers(){
        try {
            return new ResponseData<>(userService.getUsers(), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        }
        catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{id}")
    public ResponseData<UserResponseDTO> getUserById(@PathVariable int id){
        try {
            return new ResponseData<>(userService.getUser(id), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        }
        catch (ResourceNotFoundException e){
            return new ResponseData<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
        catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<Long> addUser(@RequestBody UserRequestDTO userRequestDTO){
        try {
            return new ResponseData<>(userService.addUser(userRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@RequestParam long userId,
                                      @RequestBody UserRequestDTO userRequestDTO){
        try {
            userService.updateUser(userId, userRequestDTO);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.getReasonPhrase());
        }
        catch (ResourceNotFoundException e){
            return new ResponseData<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
        catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{ids}")
    public ResponseData<?> deleteUser(@PathVariable List<Long> ids){
        try {
            userService.deleteUser(ids);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(),HttpStatus.NO_CONTENT.getReasonPhrase());
        } catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}