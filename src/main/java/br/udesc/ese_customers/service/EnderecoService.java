package br.udesc.ese_customers.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.udesc.ese_customers.model.EnderecoModel;
import br.udesc.ese_customers.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repository;
	
	public Page<EnderecoModel> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<EnderecoModel> findById(UUID id) {
		return repository.findById(id);
	}
	
	public Optional<EnderecoModel> findByClienteId(UUID clienteId) {
		return repository.findByClienteId(clienteId);
	}
	
	@Transactional
	public EnderecoModel save(EnderecoModel endereco) {
		return repository.save(endereco);
	}
	
	public void delete(EnderecoModel endereco) {
		repository.delete(endereco);
	}
	
}