package com.srm.asset.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.srm.asset.app.enums.RiscoEnum;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -8392970102876097390L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nome", nullable = true)
	private String nome;

	@Column(name = "limite_credito", nullable = true)
	private BigDecimal limiteCredito;

	@Enumerated(EnumType.STRING)
	@Column(name = "risco", nullable = true)
	private RiscoEnum risco;

	@Column(name = "data_criacao", nullable = true)
	private Date dataCriacao;

	@Column(name = "tx_juros", nullable = true)
	private int txJuros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public RiscoEnum getRisco() {
		return risco;
	}

	public void setRisco(RiscoEnum risco) {
		this.risco = risco;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getTxJuros() {
		return txJuros;
	}

	public void setTxJuros(int txJuros) {
		this.txJuros = txJuros;
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", limiteCredito=" + limiteCredito + ", risco=" + risco
				+ ", dataCriacao=" + dataCriacao + ", txJuros=" + txJuros + "]";
	}

}
