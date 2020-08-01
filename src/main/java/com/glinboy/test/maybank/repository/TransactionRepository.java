package com.glinboy.test.maybank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.glinboy.test.maybank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>,
	JpaSpecificationExecutor<Transaction> {

	Page<Transaction> findAllByCustomerId(Long customerId, Pageable pageable);

	Page<Transaction> findAllByAccountNumber(String accountNumber, Pageable pageable);

	Page<Transaction> findAllByDescription(String description, Pageable pageable);

}
