package br.com.calcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.dto.AnalysisResultDto;
import br.com.calcard.entity.AnalysisResult;
import br.com.calcard.service.AnalysisResultService;

@RestController
@RequestMapping("/analysis")
public class AnalysisResultController {

	@Autowired
	private AnalysisResultService service;
	
	@PostMapping
	public ResponseEntity<AnalysisResult> save(@RequestBody AnalysisResultDto analysisResultDto) {
		return service.save(analysisResultDto);
	}
	
}
