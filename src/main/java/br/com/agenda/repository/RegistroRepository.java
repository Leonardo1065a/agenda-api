package br.com.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM REGISTRO")
    public List<Registro> findAllRegistros();
	
	@Query(nativeQuery = true, value = "SELECT * FROM REGISTRO R WHERE R.ID = :id")
    public Registro findRegistroById(Long id);
}
