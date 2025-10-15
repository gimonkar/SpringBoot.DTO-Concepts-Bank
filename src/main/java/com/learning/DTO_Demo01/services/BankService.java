package com.learning.DTO_Demo01.services;

import com.learning.DTO_Demo01.dtos.AccountDTO;
import com.learning.DTO_Demo01.entity.Bank;
import com.learning.DTO_Demo01.repositories.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class BankService {
    @Autowired
    BankRepo repo;

    public Bank saveNewAccount(Bank bank){
        return repo.save(bank);
    }
    // It will show all information from my entity i dont want to show all.
    public Optional<List<Bank>> getAllAccounts(){
        List<Bank> accountList = repo.findAll();
        return Optional.of(accountList);
    }
    // It will give online required fields according to my DTO
    public Optional<List<AccountDTO>> getAllAccountsAbstract(){
        List<AccountDTO> abstractInfo = new LinkedList<AccountDTO>();
        List<Bank> accountList = repo.findAll();
        Iterator<Bank> itr = accountList.iterator();
        while (itr.hasNext()){
            AccountDTO acc = new AccountDTO();
            Bank bank = itr.next();
            acc.setId(bank.getId());
            acc.setAccountNumber(bank.getAccountNumber());
            acc.setAccountType(bank.getAccountType());
            acc.setName(bank.getName());
            abstractInfo.add(acc);
        }
        return Optional.of(abstractInfo);
    }

    public Optional<Bank> findUserByUserId(long userId){
        return repo.findById(userId);
    }

    public ResponseEntity<String> deleteByUserId(long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("Entry Deleted");
        } else{
            return ResponseEntity.badRequest().body("Requested id not fount");
        }
    }
}

