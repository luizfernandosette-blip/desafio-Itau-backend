package desafio.itau.springBoot.controllers;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springBoot.model.dto.StatisticsDto;
import desafio.itau.springBoot.services.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatisctsController {

	@Autowired
	private TransactionService service;
	
	@GetMapping
	public ResponseEntity<StatisticsDto> getStatistics(){
		DoubleSummaryStatistics stats = service.getStatistics();
		return ResponseEntity.ok(new StatisticsDto(stats));
	}
}
