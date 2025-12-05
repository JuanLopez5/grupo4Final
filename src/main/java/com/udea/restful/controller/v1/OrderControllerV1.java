package com.udea.restful.controller.v1;

import com.udea.restful.config.ApiMediaType;
import com.udea.restful.dto.OrderRequestDto;
import com.udea.restful.hateoas.OrderModelAssembler;
import com.udea.restful.model.Order;
import com.udea.restful.service.OrderService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerV1 {

    private final OrderService orderService;
    private final OrderModelAssembler assembler;

    public OrderControllerV1(OrderService orderService,
                             OrderModelAssembler assembler) {
        this.orderService = orderService;
        this.assembler = assembler;
    }

    @GetMapping(value = "/{id}", produces = ApiMediaType.V1_ORDER)
    public ResponseEntity<EntityModel<?>> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(assembler.toModel(order));
    }

    @PostMapping(produces = ApiMediaType.V1_ORDER,
            consumes = "application/json")
    public ResponseEntity<EntityModel<?>> createOrder(@RequestBody OrderRequestDto dto) {

        Order newOrder = orderService.createOrder(dto);

        return ResponseEntity
                .created(linkTo(methodOn(OrderControllerV1.class)
                        .getOrder(newOrder.getId())).toUri())
                .body(assembler.toModel(newOrder));
    }


    @GetMapping(value = "/customer/{id}", produces = ApiMediaType.V1_ORDER)
    public ResponseEntity<String> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok("Cliente con id = " + id);
    }
}
