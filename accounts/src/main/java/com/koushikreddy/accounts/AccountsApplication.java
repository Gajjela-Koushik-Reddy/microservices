package com.koushikreddy.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.koushikreddy.accounts.entity.Customer;

@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);

		Object obj = new Customer();
		System.out.println(obj.toString());
	}

}
