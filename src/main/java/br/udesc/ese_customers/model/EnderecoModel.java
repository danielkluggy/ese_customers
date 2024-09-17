package br.udesc.ese_customers.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class EnderecoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID enderecoId;
	
	@Column(nullable = false, length = 255)
	private String logradouro;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(length = 100)
	private String complemento;
	
	@Column(nullable = false, length = 100)
	private String bairro;
	
	@Column(nullable = false, length = 100)
	private String cidade;
	
	@Column(nullable = false, length = 2)
	private String estado;
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clienteId")
	private ClienteModel clienteId;

	public EnderecoModel() {
	}

	public UUID getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(UUID enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public ClienteModel getClienteId() {
		return clienteId;
	}

	public void setClienteId(ClienteModel clienteId) {
		this.clienteId = clienteId;
	}

}