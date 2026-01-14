package desafio.itau.springBoot.model.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransactionDto {

	@NotNull
	private double valor;
	
	@NotNull
	private OffsetDateTime dataHora;
	
	public TransactionDto(double valor, OffsetDateTime datahora) {
		this.valor = valor;
		this.dataHora = datahora;
	}
	
	public double getValor() {
		return valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	
}
