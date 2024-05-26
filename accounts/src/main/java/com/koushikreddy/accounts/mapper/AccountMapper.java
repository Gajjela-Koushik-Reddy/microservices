package com.koushikreddy.accounts.mapper;

import com.koushikreddy.accounts.dto.AccountDto;
import com.koushikreddy.accounts.entity.Accounts;

/* 
 * This class is used to map DTO to Entity and Entity to DTO
 */

public class AccountMapper {
    public static AccountDto mapToAccountDto(Accounts account, AccountDto accountDto) {

        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;

    }

    public static Accounts mapToAccount(AccountDto accountDto, Accounts account) {

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
