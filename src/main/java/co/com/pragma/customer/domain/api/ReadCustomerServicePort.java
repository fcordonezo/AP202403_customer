package co.com.pragma.customer.domain.api;

import co.com.pragma.customer.domain.model.Customer;

public interface ReadCustomerServicePort {
  Customer readById(Long customerId);
}
