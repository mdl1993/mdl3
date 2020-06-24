package it.sincrono.repositories;

import java.util.List;


import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.exceptions.RepositoryException;

public interface AnagraficaCustomRepository extends BaseCustomRepository {
	
	public List<Anagrafica> search(Anagrafica anagrafica) throws RepositoryException;
}