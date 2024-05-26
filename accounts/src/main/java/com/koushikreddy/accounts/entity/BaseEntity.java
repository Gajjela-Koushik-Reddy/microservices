package com.koushikreddy.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
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
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = false)
    LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    String createdBy;

    @Column(insertable = false)
    LocalDateTime updatedAt;

    @Column(insertable = false)
    String updatedBy;

}
