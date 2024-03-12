package co.com.pragma.customer.domain.spi;

import co.com.pragma.customer.domain.model.Customer;

import java.util.List;

public interface CustomerPersistencePort {
  List<Customer> findAll();
  Customer findById(Long idCustomer);
  Customer save(Customer customer);
  Customer update(Customer customer, Long idCustomer);
  void delete(Long customerId);
}
