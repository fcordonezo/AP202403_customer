package co.com.pragma.customer.domain.usecase;

import co.com.pragma.customer.domain.api.CRUDCustomerServicePort;
import co.com.pragma.customer.domain.model.Customer;
import co.com.pragma.customer.domain.spi.CustomerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDCustomerUseCase implements CRUDCustomerServicePort {

  private final CustomerPersistencePort customerPersistencePort;

  @Autowired
  public CRUDCustomerUseCase(CustomerPersistencePort customerPersistencePort) {
    this.customerPersistencePort = customerPersistencePort;
  }

  @Override
  public Customer readById(Long customerId) {
    return customerPersistencePort.findById(customerId);
  }

  @Override
  public List<Customer> readAll() {
    return customerPersistencePort.findAll();
  }

  @Override
  public Customer create(Customer customer) {
    return customerPersistencePort.save(customer);
  }

  @Override
  public Customer update(Customer customer, Long customerId) {
    return customerPersistencePort.update(customer, customerId);
  }

  @Override
  public void delete(Long customerId) {
    customerPersistencePort.delete(customerId);
  }
}
