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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "limite_credito", nullable = false)
	private BigDecimal limiteCredito;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private RiscoEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

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

	public RiscoEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(RiscoEnum perfil) {
		this.perfil = perfil;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
    }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", limiteCredito=" + limiteCredito + ", perfil=" + perfil
				+ ", dataCriacao=" + dataCriacao + "]";
	}

}
