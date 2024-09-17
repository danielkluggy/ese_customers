package br.udesc.ese_customers.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class ClienteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID clienteId;
	
	@Column(nullable = false, length = 255)
	private String nome;
	
	@Column(nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtExclusao;

	public ClienteModel() {
	}

	public UUID getClienteId() {
		return clienteId;
	}

	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtExclusao() {
		return dtExclusao;
	}

	public void setDtExclusao(Date dtExclusao) {
		this.dtExclusao = dtExclusao;
	}

}