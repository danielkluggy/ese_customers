package br.udesc.ese_customers.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.udesc.ese_customers.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID>{
	
	@Query(value = "SELECT * FROM cliente WHERE cpf=?", nativeQuery = true)
	Optional<ClienteModel> findByCpf(String cpf);
	
	@Query("SELECT c FROM ClienteModel c WHERE c.dtExclusao IS NULL")
    Page<ClienteModel> findAllNotExcluded(Pageable pageable);
	
}