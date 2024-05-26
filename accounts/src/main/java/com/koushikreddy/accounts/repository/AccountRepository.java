package com.koushikreddy.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koushikreddy.accounts.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
