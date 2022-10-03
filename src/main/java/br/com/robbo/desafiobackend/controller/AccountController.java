package br.com.robbo.desafiobackend.controller;

import br.com.robbo.desafiobackend.entity.Account;
import br.com.robbo.desafiobackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Validated Account account) {
        Account accountResp = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResp);
    }

    @PostMapping ("/withdraw")
    public ResponseEntity<Account> withdraw(@RequestParam Integer accountNumber, @RequestParam BigDecimal cashValue){
        Account account = accountService.withdraw(accountNumber, cashValue);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(account);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestParam Integer originAccountNumber, @RequestParam Integer targetAccountNumber, @RequestParam BigDecimal cashValue ){
        accountService.transfer(originAccountNumber,targetAccountNumber,cashValue);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestParam Integer accountNumber, @RequestParam BigDecimal cashValue){
        accountService.deposit(accountNumber,cashValue);
        return ResponseEntity.accepted().build();
    }
}
