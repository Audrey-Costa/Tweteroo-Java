package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
  List<TweetModel> findByUsername(String username);
  Page<TweetModel> findAllByOrderByIdDesc(Pageable pegeable);
}
