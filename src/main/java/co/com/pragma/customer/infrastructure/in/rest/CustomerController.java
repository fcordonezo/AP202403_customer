package co.com.pragma.customer.infrastructure.in.rest;

import co.com.pragma.customer.application.dto.CustomerRequestDto;
import co.com.pragma.customer.application.dto.CustomerResponseDto;
import co.com.pragma.customer.application.handler.CustomerHandler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
  private final CustomerHandler customerHandler;

  @Autowired
  public CustomerController(CustomerHandler customerHandler) {
    this.customerHandler = customerHandler;
  }

  @Operation(summary = "Obtener cliente por ID")
  @GetMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerResponseDto> getById(@PathVariable("customerId") Long customerId) {
    CustomerResponseDto customerResponseDto = customerHandler.getById(customerId);
    return ResponseEntity.ok(customerResponseDto);
  }

  @Operation(summary = "Obtener todos los clientes")
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CustomerResponseDto>> getAll() {
    List<CustomerResponseDto> customerResponseDto = customerHandler.getAll();
    return ResponseEntity.ok(customerResponseDto);
  }

  @Operation(summary = "Agregar un cliente")
  @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CustomerResponseDto> post(@RequestBody CustomerRequestDto dto) {
    CustomerResponseDto customerResponseDto = customerHandler.post(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
  }

  @Operation(summary = "Actualizar un cliente")
  @PutMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerResponseDto> put(@RequestBody CustomerRequestDto dto, @PathVariable("customerId") Long customerId) {
    CustomerResponseDto customerResponseDto = customerHandler.put(dto, customerId);
    return ResponseEntity.ok(customerResponseDto);
  }

  @Operation(summary = "Eliminar un cliente por ID")
  @DeleteMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> delete(@PathVariable("customerId") Long customerId) {
    customerHandler.delete(customerId);
    return ResponseEntity.ok().build();
  }
}
