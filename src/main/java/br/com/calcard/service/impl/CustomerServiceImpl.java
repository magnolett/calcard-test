package br.com.calcard.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.calcard.dto.CustomerDto;
import br.com.calcard.entity.Customer;
import br.com.calcard.repository.CustomerRepository;
import br.com.calcard.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Customer findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public ResponseEntity<Customer> save(CustomerDto customerDto) {
		return new ResponseEntity<>(repository.saveAndFlush(convertToEntity(customerDto)), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<Customer>> findAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK); 
	}

	public CustomerDto convertToDto(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}
	
	public Customer convertToEntity(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}


}
