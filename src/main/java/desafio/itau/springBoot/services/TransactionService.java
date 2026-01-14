package desafio.itau.springBoot.services;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import desafio.itau.springBoot.model.dto.TransactionDto;

@Service
public class TransactionService {

	private final Queue<TransactionDto> transactions = new ConcurrentLinkedQueue<>();  //Collection semelhante ao arraylist
	
	public void addTransaction(TransactionDto transaction) {
		transactions.add(transaction);
	}
	
	public void clearTransactions() {
		transactions.clear();
	}
	
	public DoubleSummaryStatistics getStatistics() {
		
		var now = OffsetDateTime.now();
		return transactions.stream().filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
				.mapToDouble(TransactionDto::getValor)
				.summaryStatistics();
	}
}
