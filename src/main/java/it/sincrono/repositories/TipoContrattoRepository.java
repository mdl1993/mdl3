package it.sincrono.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.sincrono.repositories.entities.TipoContratto;

public interface TipoContrattoRepository extends JpaRepository<TipoContratto, Integer>, TipoContrattoCustomRepository {

	@Query(value = "SELECT a FROM TipoContratto a ORDER BY a.descrizione ASC")
	public List<TipoContratto> list();
}