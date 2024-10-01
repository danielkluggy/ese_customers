package br.udesc.ese_customers.dto;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDto {	
	
	@NotBlank
	@Size(max = 255, message = "O logradouro excede o tamanho máximo permitido de caracteres")
	private String logradouro;
	
	@Min(value = 0, message = "É obrigatório informar um número positivo")
	private Integer numero;
	
	@Size(max = 100, message = "O complemento excede o tamanho máximo permitido de caracteres")
	private String complemento;
	
	@NotBlank
	@Size(max = 100, message = "O bairro excede o tamanho máximo permitido de caracteres")
	private String bairro;
	
	@NotBlank
	@Size(max = 100, message = "A cidade excede o tamanho máximo permitido de caracteres")
	private String cidade;
	
	@NotBlank
	@Size(min = 2, max = 2, message = "O estado precisa ter 2 caracteres")
	private String estado;
	
	@NotBlank
	@Size(min = 8, max = 8, message = "O CEP precisa ter 8 caracteres")
	private String cep;
	
	private UUID clienteId;
}
