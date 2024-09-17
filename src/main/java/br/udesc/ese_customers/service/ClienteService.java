package br.udesc.ese_customers.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.udesc.ese_customers.model.ClienteModel;
import br.udesc.ese_customers.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Page<ClienteModel> findAll(Pageable pageable) {
		return repository.findAllNotExcluded(pageable);
	}

	public Optional<ClienteModel> findById(UUID id) {
		return repository.findById(id);
	}
	
	public Optional<ClienteModel> findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	
	@Transactional
	public ClienteModel save(ClienteModel cliente) {
		return repository.save(cliente);
	}
	
	public void delete(ClienteModel cliente) {
		cliente.setDtExclusao(new Date());
		repository.save(cliente);
	}
	
}