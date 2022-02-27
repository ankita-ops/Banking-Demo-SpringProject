package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class DefaultAccountService implements AccountService {
    @Autowired
    private AccountRepository repository;
    public DefaultAccountService(){

    };
    public void setRepository(AccountRepository repository){
        this.repository=repository;

    }
    @Override
    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

}
