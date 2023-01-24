package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record TextDTO(
  @NotBlank
  String text
) {
  
}
