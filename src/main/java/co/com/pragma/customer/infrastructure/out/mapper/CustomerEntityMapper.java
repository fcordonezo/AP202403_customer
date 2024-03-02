package co.com.pragma.customer.infrastructure.out.mapper;

import co.com.pragma.customer.domain.model.Customer;
import co.com.pragma.customer.infrastructure.out.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

  public Customer toCustomer(CustomerEntity entity) {
    return Customer.builder()
      .customerId(entity.getCustomerId())
      .fullName(entity.getFullName())
      .accessPassword(entity.getAccessPassword())
      .income(entity.getIncome())
      .city(entity.getCity())
      .age(entity.getAge())
      .build();
  }
  public CustomerEntity toCustomerEntity(Customer customer) {
    return CustomerEntity.builder()
      .customerId(customer.customerId())
      .fullName(customer.fullName())
      .accessPassword(customer.accessPassword())
      .income(customer.income())
      .city(customer.city())
      .age(customer.age())
      .build();
  }
}
