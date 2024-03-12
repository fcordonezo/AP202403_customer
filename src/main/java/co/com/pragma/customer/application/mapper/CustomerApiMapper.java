package co.com.pragma.customer.application.mapper;

import co.com.pragma.customer.application.dto.CustomerRequestDto;
import co.com.pragma.customer.application.dto.CustomerResponseDto;
import co.com.pragma.customer.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerApiMapper {

  Customer toCustomer(CustomerRequestDto dto);
  CustomerResponseDto toCustomerResponseDto(Customer customer);
}
