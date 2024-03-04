package co.com.pragma.customer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record Customer(
  Long customerId,
  String fullName,
  String accessPassword,
  Float income,
  String city,
  String countryCode,
  Integer age) {
}
