package com.glinboy.test.maybank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.glinboy.test.maybank.model.Transaction;
import com.glinboy.test.maybank.service.TransactionService;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController extends AbstractController<Transaction, TransactionService> {

	private final Logger log = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService trxService;
	
	public TransactionController(TransactionService service) {
		super(service);
		this.trxService = service;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<List<Transaction>> uploadFile(@RequestParam("file") MultipartFile file) {
		log.info("Start saving Data from: {}", file.getOriginalFilename());
		List<Transaction> storedData = trxService.storeFileData(file);
		return ResponseEntity.status(HttpStatus.CREATED).body(storedData);
	}
	
}
