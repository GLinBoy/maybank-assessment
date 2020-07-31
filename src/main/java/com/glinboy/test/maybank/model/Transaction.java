package com.glinboy.test.maybank.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Transaction extends BaseEntity {

	private String accountNumber;
	private BigDecimal trxAmount;
	private String description;
	private LocalDate trxDate;
	private LocalTime trxTime;
	private Long customerId;

}
