package co.com.pragma.customer.infrastructure.in.rest;

import co.com.pragma.customer.application.dto.CustomerResponseDto;
import co.com.pragma.customer.application.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {
  private final CustomerHandler customerHandler;

  @Autowired
  public CustomerController(CustomerHandler customerHandler) {
    this.customerHandler = customerHandler;
  }

  @GetMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerResponseDto> getById(@PathVariable("customerId") Long customerId) {
    CustomerResponseDto customerResponseDto = customerHandler.getById(customerId);
    return ResponseEntity.ok(customerResponseDto);
  }
}
