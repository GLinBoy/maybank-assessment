package com.glinboy.test.maybank.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.test.maybank.model.Transaction;
import com.glinboy.test.maybank.repository.TransactionRepository;
import com.glinboy.test.maybank.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl extends AbstractServiceImpl<Transaction, TransactionRepository> implements TransactionService {

}
