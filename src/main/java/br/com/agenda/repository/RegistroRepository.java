package br.com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{
	
}
