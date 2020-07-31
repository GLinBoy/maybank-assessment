package com.glinboy.test.maybank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.glinboy.test.maybank.model.Transaction;

public interface TransactionService extends GenericService<Transaction> {

	List<Transaction> storeFileData(MultipartFile file);

}
