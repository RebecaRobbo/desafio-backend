package br.com.robbo.desafiobackend.service.impl;

import br.com.robbo.desafiobackend.entity.Account;
import br.com.robbo.desafiobackend.entity.User;
import br.com.robbo.desafiobackend.repository.AccountRepository;
import br.com.robbo.desafiobackend.service.AccountService;
import br.com.robbo.desafiobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Override
    public Account createAccount(Account account) {
        User user = null;
        Account accountResp = null;
        try {
            if (account != null) {
                user = userValidate(account.getUser());
            }

            if (user == null) {
                accountResp = accountRepository.save(account);
            } else {
                throw new RuntimeException("Usuário já cadastrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return accountResp;
    }

    @Override
    public void deposit(Integer accountNumber, BigDecimal cashValue) {
        Account account = accountRepository.findAccountByNumberAccount(accountNumber);
        try {
            if (account != null) {
                BigDecimal balance = account.getBalance();
                if (cashValidate(cashValue)) {
                    account.setBalance(balance.add(cashValue));
                    accountRepository.save(account);
                } else {
                    throw new RuntimeException("Valor inválido!");
                }
            } else {
                throw new RuntimeException("Conta inexistente!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void transfer(Integer originAccountNumber, Integer targetAccountNumber, BigDecimal cashValue) {
        Account targetAccount = accountRepository.findAccountByNumberAccount(targetAccountNumber);
        try {
            if (targetAccount != null) {
                Account originAccount = withdraw(originAccountNumber, cashValue);
                targetAccount.setBalance(targetAccount.getBalance().add(cashValue));
                accountRepository.saveAll(Arrays.asList(originAccount, targetAccount));
            } else {
                throw new RuntimeException("Conta inválida!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account withdraw(Integer accountNumber, BigDecimal cashValue) {
        Account account = accountRepository.findAccountByNumberAccount(accountNumber);
        try {
            if (account != null) {
                if (cashValue.doubleValue() <= account.getBalance().doubleValue()) {
                    account.setBalance(account.getBalance().subtract(cashValue));
                    accountRepository.save(account);
                } else {
                    throw new RuntimeException("Saldo insuficiente");
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    private User userValidate(User user) {
        User userResp = null;
        if (user != null) {
            userResp = userService.findByCPF(user.getCpf());
        }

        if (userResp == null) {
            return null;
        } else {
            return userResp;
        }
    }

    private Boolean cashValidate(BigDecimal cashValue) {
        if (cashValue.intValue() > 0 && cashValue.intValue() <= 2000) {
            return true;
        } else {
            return false;
        }
    }
}
