package com.glinboy.test.maybank.service.impl;

import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.glinboy.test.maybank.model.BaseEntity;
import com.glinboy.test.maybank.service.GenericService;

@Service
public abstract class AbstractServiceImpl<T extends BaseEntity, S extends JpaRepository<T, Long>>
		implements GenericService<T> {

	private final ResourceBundle messages = PropertyResourceBundle.getBundle("i18n/messages");

	@Autowired
	protected S repository;

	@Override
	@Transactional
	public T save(T t) {
		return repository.save(t);
	}
	
	@Override
	public List<T> saveAll(List<T> t) {
		return repository.saveAll(t);
	}

	@Override
	@Transactional
	public T update(T t) {
		final Long id = t.getId();
		t = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				messages.getString("common.error.not.found").concat(id.toString())));
		return repository.save(t);
	}

	@Override
	public T getSingleById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				messages.getString("common.error.not.found").concat(id.toString())));
	}
	
	@Override
	public Long count() {
		return repository.count();
	}
	
	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public void deleteSingleById(Long id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				messages.getString("common.error.not.found").concat(id.toString())));
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteSingleByReference(T t) {
		repository.findById(t.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				messages.getString("common.error.not.found").concat(t.getId().toString())));
		repository.delete(t);
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}
}
