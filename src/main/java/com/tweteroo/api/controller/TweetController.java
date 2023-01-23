package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;

@RestController
@RequestMapping
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping("/tweets")
  public List<TweetModel> listTweetsPage() {
    
  }

  @GetMapping("/tweets")
  public List<TweetModel> listUserTweets() {

  }

  @PostMapping("/tweets")
  public void postTweet() {

  }

}
