package it.sincrono.repositories.impl;

import java.util.*;

import javax.persistence.Query;

import it.sincrono.repositories.AnagraficaCustomRepository;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.exceptions.RepositoryException;

public class AnagraficaRepositoryImpl extends BaseRepositoryImpl implements AnagraficaCustomRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Anagrafica> search(Anagrafica anagrafica) throws RepositoryException {

		List<Anagrafica> list = new ArrayList<Anagrafica>();

		try {

			String queryString = SqlStrings.SQL_SEARCH_ANAGRAFICA;

			String subString = "";

			if(anagrafica != null) {

				if(anagrafica.getNome() != null) {
					subString += "AND a.nome LIKE '" + anagrafica.getNome() + "%' ";
				}

				if(anagrafica.getCognome() != null) {
					subString += "AND a.cognome LIKE '" + anagrafica.getCognome() + "%' ";
				}

				if(anagrafica.getCodiceFiscale() != null) {
					subString += "AND a.codiceFiscale = '" + anagrafica.getCodiceFiscale() + "'";
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