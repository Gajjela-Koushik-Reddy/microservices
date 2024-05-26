package com.koushikreddy.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.koushikreddy.accounts.entity.Customers;

@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);

		Object obj = new Customers();
		System.out.println(obj.toString());
	}

}
