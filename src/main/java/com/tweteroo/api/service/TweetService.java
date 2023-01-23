package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository repository;

  public void listTweetPage() {
  }

  public void listAllUserTweets() {

  }

  public void postTweet() {
    
  }
}
