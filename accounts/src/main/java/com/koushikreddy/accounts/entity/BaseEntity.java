package com.koushikreddy.accounts.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // to specify the class that will be used to get the current auditor
public class BaseEntity {

    @CreatedDate // to indicate that the field should be populated with the current date and time
                 // when the entity is persisted
    @Column(updatable = false)
    LocalDateTime createdAt;

    @CreatedBy // to indicate that the field should be populated with the user who created the
               // entity
    @Column(name = "created_by", updatable = false)
    String createdBy;

    @LastModifiedDate // to indicate that the field should be populated with the current date and time
                      // when the entity is updated
    @Column(insertable = false)
    LocalDateTime updatedAt;

    @LastModifiedBy // to indicate that the field should be populated with the user who updated the
                    // entity
    @Column(insertable = false)
    String updatedBy;

}
