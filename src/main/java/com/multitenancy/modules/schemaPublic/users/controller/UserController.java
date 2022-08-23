package com.multitenancy.modules.schemaPublic.users.controller;

import com.multitenancy.modules.schemaPublic.users.dto.UserPost;
import com.multitenancy.modules.schemaPublic.users.entity.User;
import com.multitenancy.modules.schemaPublic.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/user"})
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<User> save(@RequestBody UserPost userPost){
        User save = service.save(userPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
