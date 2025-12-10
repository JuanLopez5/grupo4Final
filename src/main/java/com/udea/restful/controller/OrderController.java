package com.udea.restful.controller;

import com.udea.restful.model.Order;
import com.udea.restful.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Pedidos", description = "Gestión de pedidos")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Operation(summary = "Obtener pedido por ID", description = "Devuelve los detalles de un pedido específico")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo pedido", description = "Registra un nuevo pedido en el sistema")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        Order savedOrder = orderRepository.save(newOrder);
        return ResponseEntity.ok(savedOrder);
    }
}