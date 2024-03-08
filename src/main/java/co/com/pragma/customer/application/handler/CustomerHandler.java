package co.com.pragma.customer.application.handler;

import co.com.pragma.customer.application.dto.CustomerRequestDto;
import co.com.pragma.customer.application.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerHandler {
  CustomerResponseDto getById(Long id);
  List<CustomerResponseDto> getAll();
  CustomerResponseDto post(CustomerRequestDto dto);
  CustomerResponseDto put(CustomerRequestDto dto, Long customerId);
  void delete(Long id);
}
