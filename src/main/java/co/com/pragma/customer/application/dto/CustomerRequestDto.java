package co.com.pragma.customer.application.dto;

import lombok.Builder;

@Builder
public record CustomerRequestDto(
  String fullName,
  String accessPassword,
  Float income,
  String city,
  String countryCode,
  Integer age
) {
}
