package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public UserModel signUp(UserDTO req) {
    UserModel user = userRepository.findByUsername(req.username());
    if(user != null){
      return null;
    }
    return userRepository.save(new UserModel(req));
  }
}
