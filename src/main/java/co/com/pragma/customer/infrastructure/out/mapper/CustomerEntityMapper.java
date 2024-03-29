package co.com.pragma.customer.infrastructure.out.mapper;

import co.com.pragma.customer.domain.model.Customer;
import co.com.pragma.customer.infrastructure.out.entity.CustomerEntity;
import org.apache.commons.codec.digest.Sha2Crypt;
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
      .countryCode(entity.getCountryCode())
      .age(entity.getAge())
      .build();
  }
  public CustomerEntity toCustomerEntity(Customer customer) {
    return CustomerEntity.builder()
      .customerId(customer.customerId())
      .fullName(customer.fullName())
      .accessPassword(Sha2Crypt.sha256Crypt(customer.accessPassword().getBytes()))
      .income(customer.income())
      .city(customer.city())
      .countryCode(customer.countryCode())
      .age(customer.age())
      .build();
  }

  public Customer addCustomerId(Customer customer, Long CustomerId) {
    return Customer.builder()
      .customerId(CustomerId)
      .fullName(customer.fullName())
      .accessPassword(customer.accessPassword())
      .income(customer.income())
      .city(customer.city())
      .countryCode(customer.countryCode())
      .age(customer.age())
      .build();
  }
}
