package br.com.calcard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisResultDto {

	private Long customerId;
	
	private Boolean analysisResult;
	
	private String limit;
	
}
