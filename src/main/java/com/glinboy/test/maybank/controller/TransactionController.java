package com.glinboy.test.maybank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.test.maybank.model.Transaction;
import com.glinboy.test.maybank.service.TransactionService;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController extends AbstractController<Transaction, TransactionService> {

	public TransactionController(TransactionService service) {
		super(service);
	}
	
}
