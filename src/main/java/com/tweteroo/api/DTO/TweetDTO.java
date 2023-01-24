package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
  @NotBlank
  String username,

  @NotBlank
  String text) {
}
