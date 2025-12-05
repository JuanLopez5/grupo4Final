package com.udea.restful.hateoas;

import com.udea.restful.controller.v1.OrderControllerV1;
import com.udea.restful.dto.OrderResponseDto;
import com.udea.restful.model.Order;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<OrderResponseDto>> {

    @Override
    public EntityModel<OrderResponseDto> toModel(Order order) {

        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus().name());
        dto.setCustomerName(order.getCustomer().getName());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setEstimatedDeliveryTime(order.getEstimatedDeliveryTime());


        return EntityModel.of(dto,
                linkTo(methodOn(OrderControllerV1.class).getOrder(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderControllerV1.class).getOrder(order.getId())).withRel("pedido"),
                linkTo(methodOn(OrderControllerV1.class).getCustomer(order.getCustomer().getId())).withRel("cliente")
        );
    }
}
