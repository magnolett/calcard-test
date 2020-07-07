package br.com.calcard.service;

import org.springframework.http.ResponseEntity;

import br.com.calcard.dto.AnalysisResultDto;
import br.com.calcard.entity.AnalysisResult;

public interface AnalysisResultService {

	AnalysisResult findById(Long id);
	ResponseEntity<AnalysisResult> save(AnalysisResultDto analysisResultDto);
	
}
