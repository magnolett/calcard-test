package br.com.calcard.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.entity.AnalysisResult;
import br.com.calcard.entity.Customer;

/**
 * Essa classe, como o próprio nome sugere, faz a análise da proposta.
 * 
 *  Prezou-se aqui pela praticidade na solução do problema conforme exemplos, muito embora entenda-se que
 * em aplicações práticas poderia-se analisar o "peso" que cada dependente teria em diferentes parâmetros salariais
 * (para quem ganha 5000, dependente tem peso menor pois a renda é considerada boa) além de outros fatores que poderiam
 * interferir como idade, estado civil e o estado em que reside, tendo em vista os diferentes custos de vida entre eles.
 * 
 * @author Marcos Agnoletto
 *
 */


@Service
public class ProposalAnalysis {

	@Autowired
	private Customer customer;
	
	private static final String MESSAGE_01 = "Reprovado pela política de crédito";
	private static final String MESSAGE_02 = "Renda baixa";
	private static final String MESSAGE_03 = "entre 100 e 500";
	private static final String MESSAGE_04 = "entre 500 e 1000";
	private static final String MESSAGE_05 = "entre 1000 e 1500";
	private static final String MESSAGE_06 = "entre 1500 e 2000";
	private static final String MESSAGE_07 = "superior 2000";
	
	public AnalysisResult proposalValidation() {
		
		final Double income = customer.getIncome();
		final Integer dependents = customer.getDependents();
		
		Double updatedIncome;
		if(income < 2001) {
			updatedIncome = income - (dependents * 1001);
		} else {
			updatedIncome = income - (dependents * 501);
		}
		
		final AnalysisResult analysisResult = new AnalysisResult();
		
		if(updatedIncome < 1000) {
			analysisResult.setAnalysisResult(false);
			
			if(income >= 1000)
				analysisResult.setLimit(MESSAGE_01);
			else {
				analysisResult.setLimit(MESSAGE_02);
			}
		} else {
			
			analysisResult.setAnalysisResult(true);
		
			if((updatedIncome >= 1000) && (updatedIncome <= 1999)) {
				analysisResult.setLimit(MESSAGE_03);
			} 
			
			if((updatedIncome > 1999) && (updatedIncome <= 3450)) {
				analysisResult.setLimit(MESSAGE_04);
				
			} 
			if((updatedIncome > 3450) && (updatedIncome <= 5999)) {
				analysisResult.setLimit(MESSAGE_05);
				
			} 
			if((updatedIncome > 5999) && (updatedIncome <= 6950)) {
				analysisResult.setLimit(MESSAGE_06);
				
			} 
			if(updatedIncome > 6950) {
				analysisResult.setLimit(MESSAGE_07);
			}
		}
		return analysisResult;
	}
	
	public AnalysisResult proposalValidationTest(Double income, Integer dependents) {
		
//		final Double income = customer.getIncome();
//		final Integer dependents = customer.getDependents();

		Double updatedIncome;
		if(income < 2001) {
			updatedIncome = income - (dependents * 1001);
		} else {
			updatedIncome = income - (dependents * 501);
		}
		
		final AnalysisResult analysisResult = new AnalysisResult();
		
		if(updatedIncome < 1000) {
			analysisResult.setAnalysisResult(false);
			
			if(income >= 1000)
				analysisResult.setLimit("Reprovado pela política de crédito");
			else {
				analysisResult.setLimit("Renda baixa");
			}
		} else {
			
			analysisResult.setAnalysisResult(true);
		
			if((updatedIncome >= 1000) && (updatedIncome <= 1999)) {
				analysisResult.setLimit("entre 100 e 500");
			} 
			
			if((updatedIncome > 1999) && (updatedIncome <= 3450)) {
				analysisResult.setLimit("entre 500 e 1000");
				
			} 
			if((updatedIncome > 3450) && (updatedIncome <= 5999)) {
				analysisResult.setLimit("entre 1000 e 1500");
				
			} 
			if((updatedIncome > 5999) && (updatedIncome <= 6950)) {
				analysisResult.setLimit("entre 1500 e 2000");
				
			} 
			if(updatedIncome > 6950) {
				analysisResult.setLimit("superior 2000");
			}
		}
		return analysisResult;
	}
	public static void main(String[] args) {
		
		ProposalAnalysis test = new ProposalAnalysis();
		System.out.println(test.proposalValidationTest(2500.0, 0).getLimit());		
		System.out.println(test.proposalValidationTest(1000.0, 0).getLimit());		
		System.out.println(test.proposalValidationTest(8000.0, 3).getLimit());		
		System.out.println(test.proposalValidationTest(5000.0, 3).getLimit());		
		System.out.println(test.proposalValidationTest(2000.0, 2).getLimit());		
		System.out.println(test.proposalValidationTest(2000.0, 1).getLimit());		
		System.out.println(test.proposalValidationTest(8000.0, 2).getLimit());		
		System.out.println(test.proposalValidationTest(10000.0, 1).getLimit());		
		System.out.println(test.proposalValidationTest(400.0, 1).getLimit());		
		System.out.println(test.proposalValidationTest(1500.0, 3).getLimit());		
		System.out.println(test.proposalValidationTest(2500.0, 2).getLimit());		
		System.out.println(test.proposalValidationTest(500.0, 0).getLimit());		
		System.out.println(test.proposalValidationTest(8000.0, 5).getLimit());		
		System.out.println(test.proposalValidationTest(10000.0, 0).getLimit());		
	}
}