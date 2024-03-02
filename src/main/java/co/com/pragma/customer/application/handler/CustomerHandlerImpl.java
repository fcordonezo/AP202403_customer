package co.com.pragma.customer.application.handler;

import co.com.pragma.customer.application.dto.CustomerResponseDto;
import co.com.pragma.customer.application.mapper.CustomerApiMapper;
import co.com.pragma.customer.domain.api.ReadCustomerServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerHandlerImpl implements CustomerHandler{

  private final ReadCustomerServicePort readCustomerServicePort;
  private final CustomerApiMapper customerApiMapper;

  @Autowired
  public CustomerHandlerImpl(
    ReadCustomerServicePort readCustomerServicePort,
    CustomerApiMapper customerApiMapper
  ) {
    this.readCustomerServicePort = readCustomerServicePort;
    this.customerApiMapper = customerApiMapper;
  }

  @Override
  public CustomerResponseDto getById(Long customerId) {
    return customerApiMapper.toCustomerResponseDto(readCustomerServicePort.readById(customerId));
  }
}
