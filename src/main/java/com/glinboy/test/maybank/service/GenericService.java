package com.glinboy.test.maybank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T> {
	T save(T t);

	T update(T t);

	T getSingleById(Long id);

	Page<T> getAll(Pageable pageable);


	void deleteSingleById(Long id);

	void deleteSingleByReference(T t);

	void deleteAll();
}