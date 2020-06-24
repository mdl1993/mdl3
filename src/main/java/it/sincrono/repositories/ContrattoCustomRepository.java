package it.sincrono.repositories;

import java.util.*;

import it.sincrono.repositories.entities.Contratto;
import it.sincrono.repositories.exceptions.RepositoryException;

public interface ContrattoCustomRepository extends BaseCustomRepository {
	public List<Contratto> search(Contratto contratto) throws RepositoryException;
}