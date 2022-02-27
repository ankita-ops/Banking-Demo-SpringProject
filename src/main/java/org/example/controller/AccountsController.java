package org.example.controller;

import org.example.model.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/accounts")

public class AccountsController {
    @Autowired
    private AccountService service;
    @GetMapping
    public List<Account> getAllAccounts()
    {
        return service.getAllAccounts();
    }
}
