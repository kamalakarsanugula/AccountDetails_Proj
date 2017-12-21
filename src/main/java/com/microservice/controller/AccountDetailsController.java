package com.microservice.controller;

import com.microservice.model.AccountDetails;
import com.microservice.repository.AccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountDetailsController {

    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    // Get All AccountDetails
    @GetMapping("/accountdetails")
    public List<AccountDetails> getAllAccountDetails() {
        return accountDetailsRepository.findAll();
    }

    // Create a new AccountDetails
    @PostMapping("/accountdetails")
    public AccountDetails createAccount(@Valid @RequestBody AccountDetails account) {
        return accountDetailsRepository.save(account);
    }

    // Get a Single AccountDetails
    @GetMapping("/accountdetails/{contractAccountNumber}")
    public ResponseEntity<AccountDetails> getNoteById(@PathVariable(value = "contractAccountNumber") Integer accountId) {
        AccountDetails account = accountDetailsRepository.findOne(accountId);
        if(account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(account);
    }

    // Update a AccountDetails
    @PutMapping("/accountdetails/{contractAccountNumber}")
    public ResponseEntity<AccountDetails> updateaccountDetails(@PathVariable(value = "contractAccountNumber") Integer accountId,
                                                               @Valid @RequestBody AccountDetails accountDetails) {
        AccountDetails account = accountDetailsRepository.findOne(accountId);
        if(account == null) {
            return ResponseEntity.notFound().build();
        }
        //account.setTitle(noteDetails.getTitle());
        //account.setContent(noteDetails.getContent());
        account.setAccountBalance(accountDetails.getAccountBalance());
        account.setDirectDebitAmt(accountDetails.getDirectDebitAmt());
        account.setMeterReadingType(accountDetails.getMeterReadingType());
        account.setPaymentPlan(accountDetails.getPaymentPlan());
        account.setService(accountDetails.getService());

        AccountDetails updatedAccountDetails = accountDetailsRepository.save(account);
        return ResponseEntity.ok(updatedAccountDetails);
    }

    // Delete a AccountDetails
    @DeleteMapping("/accountdetails/{contractAccountNumber}")
    public ResponseEntity<AccountDetails> deleteNote(@PathVariable(value = "contractAccountNumber") Integer accountId) {
        AccountDetails account = accountDetailsRepository.findOne(accountId);
        if(account == null) {
            return ResponseEntity.notFound().build();
        }

        accountDetailsRepository.delete(account);
        return ResponseEntity.ok().build();
    }

}
