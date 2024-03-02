package co.com.pragma.customer.domain.model;

import lombok.Builder;

@Builder
public record Customer(
  Long idCustomer,
  DocumentType documentType,
  String documentNumber,
  String fullName,
  String accessPassword,
  Float income,
  String city,
  Integer age) {
}
