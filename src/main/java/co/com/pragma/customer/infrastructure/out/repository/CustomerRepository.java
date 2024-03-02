package co.com.pragma.customer.infrastructure.out.repository;

import co.com.pragma.customer.infrastructure.out.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
