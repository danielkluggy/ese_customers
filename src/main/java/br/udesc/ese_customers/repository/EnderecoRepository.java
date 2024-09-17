package br.udesc.ese_customers.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.udesc.ese_customers.model.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID>{
	
	@Query(value = "SELECT * FROM endereco WHERE cliente_id=?", nativeQuery = true)
	public Optional<EnderecoModel> findByClienteId(UUID clienteId);
	
}