package com.koushikreddy.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koushikreddy.accounts.entity.Customer;

// This interface extends JpaRepository to perform CRUD operations on the Customer entity
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
