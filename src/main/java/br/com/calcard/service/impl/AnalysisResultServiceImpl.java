package br.com.calcard.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.calcard.dto.AnalysisResultDto;
import br.com.calcard.entity.AnalysisResult;
import br.com.calcard.repository.AnalysisResultRepository;
import br.com.calcard.service.AnalysisResultService;

@Service
public class AnalysisResultServiceImpl implements AnalysisResultService {

	@Autowired
	private AnalysisResultRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AnalysisResult findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public ResponseEntity<AnalysisResult> save(AnalysisResultDto analysisResultDto) {
		return new ResponseEntity<>(repository.saveAndFlush(convertToEntity(analysisResultDto)), HttpStatus.OK);
	}
	
	public AnalysisResultDto convertToDto(AnalysisResult analysisResult) {
		return modelMapper.map(analysisResult, AnalysisResultDto.class);
	}
	
	public AnalysisResult convertToEntity(AnalysisResultDto analysisResultDto) {
		return modelMapper.map(analysisResultDto, AnalysisResult.class);
	}
	

}
