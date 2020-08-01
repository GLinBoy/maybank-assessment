package com.glinboy.test.maybank.graphql.query;

import java.util.List;

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
	
	public List<Transaction> getTransactions() {
		return this.transactionService.getAll();
	}
}
