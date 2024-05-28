package com.koushikreddy.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.koushikreddy.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional // if there is any exception in the middle of the transaction, it will rollback the transaction
    @Modifying // to indicate that the query is modifying the data
    void deleteByCustomerId(Long customerId);

}
