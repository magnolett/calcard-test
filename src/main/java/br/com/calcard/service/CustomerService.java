package br.com.calcard.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.calcard.dto.CustomerDto;
import br.com.calcard.entity.Customer;

public interface CustomerService {

	Customer findById(Long id);
	ResponseEntity<Customer> save(CustomerDto customerDto);
	ResponseEntity<List<Customer>> findAll();
	
}
