package br.com.calcard.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.dto.CustomerDto;
import br.com.calcard.entity.Customer;
import br.com.calcard.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody CustomerDto customerDto) {
		return service.save(customerDto);
	}
	
    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
    	ResponseEntity<List<Customer>> allCustomers = service.findAll();
		List<CustomerDto> dtos = allCustomers.getBody().stream().map(this::convertToDto).collect(Collectors.toList());
    	return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable(required = true) Long id) {
		return new ResponseEntity<>(convertToDto(service.findById(id)), HttpStatus.OK);
    }
    
    private CustomerDto convertToDto(Customer customer) {
    	return mapper.map(customer, CustomerDto.class);
    }
}
