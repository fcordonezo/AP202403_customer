package co.com.pragma.customer.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
@Setter
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "access_password")
  private String accessPassword;

  @Column(name = "income")
  private Float income;

  @Column(name = "city")
  private String city;

  @Column(name = "age")
  private Integer age;

}
