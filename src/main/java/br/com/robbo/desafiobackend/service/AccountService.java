package br.com.robbo.desafiobackend.service;

import br.com.robbo.desafiobackend.entity.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account createAccount(Account account);

    void deposit(Integer accountNumber, BigDecimal cashValue);

    void transfer(Integer originAccount, Integer targetAccount, BigDecimal cashValue);

    Account withdraw(Integer accountNumber, BigDecimal cashValue);
}
