package com.srm.asset.app.dtos;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class ClienteDto {

	private String nome;
	private BigDecimal limiteCredito;
	private String risco;

	@NotEmpty(message = "Nome não pode ser vazia.")
	@Length(min = 5, max = 200, message = "Nome deve conter entre 5 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

}