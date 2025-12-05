package com.udea.restful.repository;

import com.udea.restful.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customer, Long> {
}
