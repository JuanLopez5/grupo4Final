package com.udea.restful.dto;

import java.time.LocalDateTime;

public class OrderRequestDto {

    private Long customerId;
    private String deliveryAddress;
    private LocalDateTime estimatedDeliveryTime;
    private String itemsDescription;
    private String notes;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public LocalDateTime getEstimatedDeliveryTime() { return estimatedDeliveryTime; }
    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getItemsDescription() { return itemsDescription; }
    public void setItemsDescription(String itemsDescription) { this.itemsDescription = itemsDescription; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
