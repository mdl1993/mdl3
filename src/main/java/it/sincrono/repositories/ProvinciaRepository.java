package it.sincrono.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.sincrono.repositories.entities.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>, ProvinciaCustomRepository {

	@Query(value = "SELECT a FROM Provincia a ORDER BY a.descrizione ASC")
	public List<Provincia> list();
}