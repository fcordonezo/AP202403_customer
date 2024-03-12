package co.com.pragma.customer.domain.api;

import co.com.pragma.customer.domain.model.Customer;

import java.util.List;

public interface CRUDCustomerServicePort {
  Customer readById(Long customerId);
  List<Customer> readAll();
  Customer create(Customer customer);
  Customer update(Customer customer, Long customerId);
  void delete(Long CustomerId);
}
