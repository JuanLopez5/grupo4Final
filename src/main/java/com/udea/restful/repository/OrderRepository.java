package com.udea.restful.repository;

import com.udea.restful.model.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<order, Long> {
}
