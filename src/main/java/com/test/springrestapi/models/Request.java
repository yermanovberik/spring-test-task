package com.test.springrestapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request")
public class Request extends AbstractEntity {

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;

}