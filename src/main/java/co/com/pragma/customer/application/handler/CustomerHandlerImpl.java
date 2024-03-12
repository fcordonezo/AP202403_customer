package co.com.pragma.customer.application.handler;

import co.com.pragma.customer.application.dto.CustomerRequestDto;
import co.com.pragma.customer.application.dto.CustomerResponseDto;
import co.com.pragma.customer.application.mapper.CustomerApiMapper;
import co.com.pragma.customer.domain.api.CRUDCustomerServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerHandlerImpl implements CustomerHandler{

  private final CRUDCustomerServicePort crudCustomerServicePort;
  private final CustomerApiMapper customerApiMapper;

  @Autowired
  public CustomerHandlerImpl(
    CRUDCustomerServicePort crudCustomerServicePort,
    CustomerApiMapper customerApiMapper
  ) {
    this.crudCustomerServicePort = crudCustomerServicePort;
    this.customerApiMapper = customerApiMapper;
  }

  @Override
  public CustomerResponseDto getById(Long customerId) {
    return customerApiMapper.toCustomerResponseDto(crudCustomerServicePort.readById(customerId));
  }

  @Override
  public List<CustomerResponseDto> getAll() {
    return crudCustomerServicePort.readAll().stream().map(customerApiMapper::toCustomerResponseDto).toList();
  }

  @Override
  public CustomerResponseDto post(CustomerRequestDto dto) {
    return customerApiMapper.toCustomerResponseDto(crudCustomerServicePort.create(customerApiMapper.toCustomer(dto)));
  }

  @Override
  public CustomerResponseDto put(CustomerRequestDto dto, Long customerId) {
    return customerApiMapper.toCustomerResponseDto(crudCustomerServicePort.update(customerApiMapper.toCustomer(dto), customerId));
  }

  @Override
  public void delete(Long id) {
    crudCustomerServicePort.delete(id);
  }
}
