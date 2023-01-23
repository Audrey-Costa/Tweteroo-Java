package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.model.TweetModel;

@RestController
@RequestMapping
public class TweetController {

  @Autowired
  private service;

  @GetMapping
  public List<TweetModel> listTweetsPage(){
    
  }

}
