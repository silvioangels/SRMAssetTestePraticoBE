package com.srm.asset.app.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class ClienteDto {

	private int id;
	private String nome;
	private BigDecimal limiteCredito;
	private String risco;
	private int txJuros;
	private BigDecimal limiteCreditoCalculado;

	@NotEmpty(message = "Nome não pode ser vazia.")
	@Length(min = 5, max = 200, message = "Nome deve conter entre 5 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Limite de Credito deve ser preenchido")
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@NotNull(message = "Risco deve ser selecionado")
	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTxJuros() {
		return txJuros;
	}

	public void setTxJuros(int txJuros) {
		this.txJuros = txJuros;
	}

	public BigDecimal getLimiteCreditoCalculado() {
		return limiteCreditoCalculado;
	}

	public void setLimiteCreditoCalculado(BigDecimal limiteCreditoCalculado) {
		this.limiteCreditoCalculado = limiteCreditoCalculado;
	}

}
