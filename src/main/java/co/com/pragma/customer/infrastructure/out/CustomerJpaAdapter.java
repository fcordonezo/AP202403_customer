package co.com.pragma.customer.infrastructure.out;

import co.com.pragma.customer.domain.model.Customer;
import co.com.pragma.customer.domain.spi.CustomerPersistencePort;
import co.com.pragma.customer.infrastructure.out.entity.CustomerEntity;
import co.com.pragma.customer.infrastructure.out.mapper.CustomerEntityMapper;
import co.com.pragma.customer.infrastructure.out.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerJpaAdapter implements CustomerPersistencePort {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  @Autowired
  public CustomerJpaAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
    this.customerRepository = customerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }

  @Override
  public List<Customer> findAll() {
    return null;
  }

  @Override
  public Customer findById(Long idCustomer) {
    CustomerEntity customer = customerRepository.findById(idCustomer).orElseThrow();
    System.out.println(customerEntityMapper.toCustomer(customer));
    return customerEntityMapper.toCustomer(customer);
  }

  @Override
  public Customer save(Customer customer) {
    return null;
  }

  @Override
  public void delete(Customer customer) {

  }
}
