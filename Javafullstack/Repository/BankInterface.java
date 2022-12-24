package com.example.Javafullstack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Javafullstack.Blueprint.Bank;

public interface BankInterface extends JpaRepository<Bank,Integer>{

}

