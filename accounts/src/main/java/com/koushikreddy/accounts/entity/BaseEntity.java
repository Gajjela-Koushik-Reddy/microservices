package com.koushikreddy.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Column(updatable = false)
    LocalDateTime createdAt;

    @Column(updatable = false)
    String createdBy;

    @Column(insertable = false)
    LocalDateTime updatedAt;

    @Column(insertable = false)
    String updatedBy;

}
