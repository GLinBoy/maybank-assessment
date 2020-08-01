package com.glinboy.test.maybank.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.glinboy.test.maybank.model.Transaction;

public interface TransactionService extends GenericService<Transaction> {

	List<Transaction> storeFileData(MultipartFile file);
	
	Page<Transaction> getTransactionsByCustomerId(Long customerId, Pageable pageable);
	
	Page<Transaction> getTransactionsByAccountNumber(String accountNumber, Pageable pageable);
	
	Page<Transaction> getTransactionsByDescription(String description, Pageable pageable);

}
