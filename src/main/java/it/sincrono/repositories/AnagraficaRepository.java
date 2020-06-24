package it.sincrono.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.sincrono.repositories.entities.Anagrafica;

public interface AnagraficaRepository extends JpaRepository<Anagrafica, Integer>, AnagraficaCustomRepository {

	@Query(value = "SELECT a FROM Anagrafica a ORDER BY a.cognome ASC, a.nome ASC")
	public List<Anagrafica> list();
}