package com.udea.restful.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private orderstatus status;

    @ManyToOne(optional = false)
    private customer customer;

    private String deliveryAddress;

    private LocalDateTime estimatedDeliveryTime;

    private LocalDateTime createdAt;

    private String itemsDescription;

    private String notes;

    public order() {}

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public orderstatus getStatus() { return status; }

    public void setStatus(orderstatus status) { this.status = status; }

    public customer getCustomer() { return customer; }

    public void setCustomer(customer customer) { this.customer = customer; }

    public String getDeliveryAddress() { return deliveryAddress; }

    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public LocalDateTime getEstimatedDeliveryTime() { return estimatedDeliveryTime; }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getItemsDescription() { return itemsDescription; }

    public void setItemsDescription(String itemsDescription) { this.itemsDescription = itemsDescription; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
