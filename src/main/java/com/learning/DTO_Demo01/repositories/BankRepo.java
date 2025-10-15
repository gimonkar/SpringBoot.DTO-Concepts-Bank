package com.learning.DTO_Demo01.repositories;

import com.learning.DTO_Demo01.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank,Long> {
}
