package br.udesc.ese_customers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDto {	

	@NotBlank
	@Size(max = 255, message = "O nome excede o tamanho máximo permitido de caracteres")
	private String nome;
	
	@Size(min = 11, max = 11, message = "O CPF precisa ter 11 dígitos")
	private String cpf;
}
