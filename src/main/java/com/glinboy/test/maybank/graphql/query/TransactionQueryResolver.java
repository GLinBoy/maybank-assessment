package com.glinboy.test.maybank.graphql.query;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.glinboy.test.maybank.model.Transaction;
import com.glinboy.test.maybank.service.TransactionService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class TransactionQueryResolver implements GraphQLQueryResolver {

	private final TransactionService transactionService;

	public TransactionQueryResolver(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	public List<Transaction> getTransactions(Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 0);
		return this.transactionService.getAll(pageable).getContent();
	}
	
	public List<Transaction> getTransactionsByCustomerId(Long customerId, Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 0);
		return this.transactionService.getTransactionsByCustomerId(customerId, pageable).getContent();
	}
	
	public List<Transaction> getTransactionsByAccountNumber(String accountNumber, Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 0);
		return this.transactionService.getTransactionsByAccountNumber(accountNumber, pageable).getContent();
	}
	
	public List<Transaction> getTransactionsByDescription(String description, Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 0);
		return this.transactionService.getTransactionsByDescription(description, pageable).getContent();
	}
	
}
