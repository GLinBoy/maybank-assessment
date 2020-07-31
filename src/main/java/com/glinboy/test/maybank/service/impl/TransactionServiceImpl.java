package com.glinboy.test.maybank.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.glinboy.test.maybank.model.Transaction;
import com.glinboy.test.maybank.repository.TransactionRepository;
import com.glinboy.test.maybank.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl extends AbstractServiceImpl<Transaction, TransactionRepository>
		implements TransactionService {

	private final ResourceBundle messages = PropertyResourceBundle.getBundle("i18n/messages");

	private final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Override
	public List<Transaction> storeFileData(MultipartFile file) {
		if (file.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messages.getString("common.error.file.empty"));
		}
		try {
			InputStream is = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			int lineNumber = 0;
			List<Transaction> trxs = new ArrayList();
			while (reader.ready()) {
				lineNumber++;
				String line = reader.readLine();
				if(lineNumber == 1) {
					continue;
				}
				trxs.add(createTransactionObject(line.split("\\|")));
			}
			return this.saveAll(trxs);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.FAILED_DEPENDENCY,
					messages.getString("common.error.file.read"), e);
		}
	}

	private Transaction createTransactionObject(String[] attributes) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(attributes[0]);
		transaction.setTrxAmount(new BigDecimal(attributes[1]));
		transaction.setDescription(attributes[2]);
		transaction.setTrxDate(LocalDate.parse(attributes[3]));
		transaction.setTrxTime(LocalTime.parse(attributes[4]));
		transaction.setCustomerId(Long.valueOf(attributes[5]));
		return transaction;
	}

}
