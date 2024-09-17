package br.udesc.ese_customers.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.ese_customers.dto.ClienteDto;
import br.udesc.ese_customers.exception.ObjectNotFoundException;
import br.udesc.ese_customers.model.ClienteModel;
import br.udesc.ese_customers.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<Page<ClienteModel>> getAll(@PageableDefault(
															page = 0,
															size = 10,
															sort = "cpf",
															direction = Sort.Direction.ASC)
															Pageable pageable
															) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") UUID id) {
		Optional<ClienteModel> clienteModelOptional = service.findById(id);
		if(!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getMessageClienteNotFound());
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid ClienteDto clienteDto) {
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);	

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteModel));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
										@RequestBody @Valid ClienteDto clienteDto) {
		Optional<ClienteModel> clienteModelOptional = service.findById(id);
		if(!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getMessageClienteNotFound());
		}
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		clienteModel.setClienteId(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.save(clienteModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) throws ObjectNotFoundException {
		Optional<ClienteModel> clienteModelOptional = service.findById(id);
		if(!clienteModelOptional.isPresent()) {
			throw new ObjectNotFoundException(getMessageClienteNotFound());
		}
		service.delete(clienteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body(getMessageClienteDeleted());
	}
	
	protected String getMessageClienteNotFound() {
		return "Cliente não encontrado";
	}
	
	protected String getMessageClienteDeleted() {
		return "Cliente deletado com sucesso!";
	}

}