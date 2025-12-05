package com.udea.restful.service;

import com.udea.restful.dto.OrderRequestDto;
import com.udea.restful.exception.ResourceNotFoundException;
import com.udea.restful.model.customer;
import com.udea.restful.model.Order;
import com.udea.restful.model.orderstatus;
import com.udea.restful.repository.CustomerRepository;
import com.udea.restful.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }


    //Crea un nuevo pedido en estado INGRESADO

    public Order createOrder(OrderRequestDto dto) {

        // Buscar el cliente asociado
        customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setEstimatedDeliveryTime(dto.getEstimatedDeliveryTime());
        order.setItemsDescription(dto.getItemsDescription());
        order.setNotes(dto.getNotes());

        order.setStatus(orderstatus.INGRESADO);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }


     // Obtiene un pedido por su ID

    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }
}
