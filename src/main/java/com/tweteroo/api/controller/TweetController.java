package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.TextDTO;
import com.tweteroo.api.DTO.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@RequestMapping
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping("/api/tweets")
  public ResponseEntity listTweetPage(@RequestParam String page) {
    int pageNumber = Integer.parseInt(page);
    Pageable byIdDesc = PageRequest.of(pageNumber, 5, Sort.by("id").descending());
    return ResponseEntity.status(200).body(service.listTweetPage(byIdDesc));
  }

  @GetMapping("/api/tweets/{username}")
  public ResponseEntity listAllUserTweets(@PathVariable String username) {
    return ResponseEntity.status(200).body(service.listAllUserTweets(username));
  }

  @PostMapping("/api/tweets")
  public ResponseEntity postTweet(@RequestBody @Valid TextDTO text, @RequestHeader("User") String username) {
    TweetDTO tweet = new TweetDTO(username, text.text());
    TweetModel created = service.postTweet(tweet);

    if(created == null){
      return ResponseEntity.status(409).build();
    }

    return ResponseEntity.status(201).build();
  }

}
