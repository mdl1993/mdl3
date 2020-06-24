package it.sincrono.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.sincrono.repositories.entities.Contratto;

public interface ContrattoRepository extends JpaRepository<Contratto, Integer>, ContrattoCustomRepository {

	@Query(value = "SELECT a FROM Contratto a ORDER BY a.matricolaUtente ASC")
	public List<Contratto> list();

	public Contratto findByMatricolaUtente(String matricolaUtente);
}