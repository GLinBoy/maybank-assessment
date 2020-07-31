package com.glinboy.test.maybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.glinboy.test.maybank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>,
	JpaSpecificationExecutor<Transaction> {

}
