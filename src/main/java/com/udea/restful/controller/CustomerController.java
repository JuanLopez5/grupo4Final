package com.udea.restful.controller;

import com.udea.restful.model.customer;
import com.udea.restful.repository.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Clientes", description = "Gestión de clientes")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Operation(summary = "Obtener cliente por ID", description = "Devuelve los detalles de un cliente específico")
    @GetMapping("/{id}")
    public ResponseEntity<customer> getCustomerById(@PathVariable Long id) {
        Optional<customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo cliente", description = "Registra un nuevo cliente en el sistema")
    @PostMapping
    public ResponseEntity<customer> createCustomer(@RequestBody customer newCustomer) {
        customer savedCustomer = customerRepository.save(newCustomer);
        return ResponseEntity.ok(savedCustomer);
    }
}