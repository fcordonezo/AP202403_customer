package co.com.pragma.customer.domain.usecase;

import co.com.pragma.customer.domain.api.ReadCustomerServicePort;
import co.com.pragma.customer.domain.model.Customer;
import co.com.pragma.customer.domain.spi.CustomerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadCustomerUseCase implements ReadCustomerServicePort {

  private final CustomerPersistencePort customerPersistencePort;

  @Autowired
  public ReadCustomerUseCase(CustomerPersistencePort customerPersistencePort) {
    this.customerPersistencePort = customerPersistencePort;
  }

  @Override
  public Customer readById(Long customerId) {
    return customerPersistencePort.findById(customerId);
  }
}
