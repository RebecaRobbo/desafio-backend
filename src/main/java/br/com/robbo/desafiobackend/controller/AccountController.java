package br.com.robbo.desafiobackend.controller;

import br.com.robbo.desafiobackend.entity.Account;
import br.com.robbo.desafiobackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
