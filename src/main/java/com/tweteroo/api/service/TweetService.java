package com.tweteroo.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  public Stream<Object> listTweetPage(Pageable page) {
    return tweetRepository.findAllByOrderByIdDesc(page).stream().map(tweet -> {
      UserModel user = userRepository.findByUsername(tweet.getUsername());
      Map<String, String> fullTweet = new HashMap<>();
      fullTweet.put("username", tweet.getUsername());
      fullTweet.put("avatar", user.getAvatar());
      fullTweet.put("text", tweet.getText());
      return fullTweet;
    });
  }

  public Stream<Object> listAllUserTweets(String username) {
    return tweetRepository.findByUsername(username).stream().map(tweet -> {
      UserModel user = userRepository.findByUsername(tweet.getUsername());
      Map<String, String> fullTweet = new HashMap<>();
      fullTweet.put("username", tweet.getUsername());
      fullTweet.put("avatar", user.getAvatar());
      fullTweet.put("text", tweet.getText());
      return fullTweet;
    });
  }

  public TweetModel postTweet(TweetDTO tweet) {
    UserModel user = userRepository.findByUsername(tweet.username());
    if(user == null){
      return null;
    }
    return tweetRepository.save(new TweetModel(tweet));
  }
}
