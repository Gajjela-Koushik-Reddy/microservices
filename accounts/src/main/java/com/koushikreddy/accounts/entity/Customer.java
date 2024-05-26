package com.koushikreddy.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Id // @Id annotation is used to specify the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue annotation is used to specify the generation
                                                        // strategies for the values of primary keys.
    @Column(name = "customer_id") // @Column annotation is used to specify the details of the column to which a
                                  // field or property will be mapped.
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
