package com.koushikreddy.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koushikreddy.accounts.entity.Customers;

// This interface extends JpaRepository to perform CRUD operations on the Customer entity
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByMobileNumber(String number);
}
