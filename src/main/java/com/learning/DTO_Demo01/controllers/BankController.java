package com.learning.DTO_Demo01.controllers;

import com.learning.DTO_Demo01.entity.Bank;
import com.learning.DTO_Demo01.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sbi/acc")
public class BankController {
    @Autowired
    BankService bankService;
    @PostMapping("new-user")
    public Bank createNewAccount(@RequestBody Bank bank){
        return bankService.saveNewAccount(bank);
    }
    @GetMapping("show-all")
    public Optional<List<Bank>> getAllAccounts(){
        return bankService.getAllAccounts();
    }
    @PostMapping("by-id")
    public Optional<Bank> findUserByUserId(@RequestParam long userId){
        return bankService.findUserByUserId(userId);
    }
    @PostMapping("delete-by-id")
    public ResponseEntity<String> deleteByUserId(@RequestParam long id){
        return bankService.deleteByUserId(id);
    }
}
