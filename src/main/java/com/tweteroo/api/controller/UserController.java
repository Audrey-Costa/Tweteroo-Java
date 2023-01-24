package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@RequestMapping
public class UserController {
  
  @Autowired
  private UserService service;

  @PostMapping("/api/auth/sign-up")
  public ResponseEntity signUp(@RequestBody @Valid UserDTO req) {
    UserModel created = service.signUp(req);

    if(created == null){
      return ResponseEntity.status(409).build();
    }

    return ResponseEntity.status(201).build();
  }
}
