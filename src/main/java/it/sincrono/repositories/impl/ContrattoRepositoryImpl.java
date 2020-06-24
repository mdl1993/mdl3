package it.sincrono.repositories.impl;

import java.util.*;

import javax.persistence.Query;

import it.sincrono.repositories.ContrattoCustomRepository;
import it.sincrono.repositories.entities.Contratto;
import it.sincrono.repositories.exceptions.RepositoryException;

public class ContrattoRepositoryImpl extends BaseRepositoryImpl implements ContrattoCustomRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Contratto> search(Contratto contratto) throws RepositoryException {

		List<Contratto> list = new ArrayList<Contratto>();

		try {

			String queryString = SqlStrings.SQL_SEARCH_CONTRATTI;

			String subString = "";

			if(contratto.getAnagrafica() != null) {

				if(contratto.getAnagrafica().getId() != null) {
					subString += "AND a.anagrafica.id = " + contratto.getAnagrafica().getId();
				}
			}

			queryString = queryString.replace("{0}", subString);

			Query query = entityManager.createQuery(queryString);

			list = query.getResultList();

		} catch(Exception e) {
			throw new RepositoryException(e);
		}

		return list;
	}
}