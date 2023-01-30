package com.wallet.creditdebit.controller;

import java.util.List;
import java.util.Optional;

import com.wallet.creditdebit.model.Account;
import com.wallet.creditdebit.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable(value = "id") Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.get();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable(value = "id") Long accountId,
                                 @RequestBody Account accountDetails) {
        Optional<Account> account = accountRepository.findById(accountId);
        Account updatedAccount = account.get();
        updatedAccount.setAccountNumber(accountDetails.getAccountNumber());
        updatedAccount.setBalance(accountDetails.getBalance());
        return accountRepository.save(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long accountId) {
        accountRepository.deleteById(accountId);
    }
}