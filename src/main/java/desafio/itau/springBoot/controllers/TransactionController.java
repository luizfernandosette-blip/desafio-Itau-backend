package desafio.itau.springBoot.controllers;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desafio.itau.springBoot.model.dto.TransactionDto;
import desafio.itau.springBoot.services.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@PostMapping
	public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDto request, String entity){
		
		if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <=0 ) {
			return ResponseEntity.status(422).build(); //unprocessable entity
			
		}
		service.addTransaction(new TransactionDto(request.getValor(), request.getDataHora()));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> clearTransactions(){
		
		return ResponseEntity.ok().build();
	}
	
}
