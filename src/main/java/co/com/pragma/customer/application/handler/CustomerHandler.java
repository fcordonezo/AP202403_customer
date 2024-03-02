package co.com.pragma.customer.application.handler;

import co.com.pragma.customer.application.dto.CustomerResponseDto;

public interface CustomerHandler {
  CustomerResponseDto getById(Long id);
}
