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
import lombok.Data;

@Entity
@Data
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
}