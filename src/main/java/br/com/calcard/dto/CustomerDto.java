package br.com.calcard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private String name;

	private Integer cpf;

	private Integer age;
	
	private String gender;
	
	private String maritalStatus;
	
	private String state;
	
	private Integer dependents;
	
	private Double income;
	
	
}
