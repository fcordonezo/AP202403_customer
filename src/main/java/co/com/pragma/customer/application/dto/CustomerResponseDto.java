package co.com.pragma.customer.application.dto;

import lombok.Builder;

@Builder
public record CustomerResponseDto(
  Long customerId,
  String fullName,
  Float income,
  String city,
  Integer age
) {
}
