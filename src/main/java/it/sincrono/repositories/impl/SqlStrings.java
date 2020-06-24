package it.sincrono.repositories.impl;

public interface SqlStrings {

	public final String SQL_SEARCH_ANAGRAFICA = "SELECT a FROM Anagrafica a WHERE 1 = 1 {0} ORDER BY a.cognome ASC,  a.nome ASC";
	public final String SQL_SEARCH_CONTRATTI = "SELECT a FROM Contratto a WHERE 1 = 1 {0} ORDER BY a.matricolaUtente ASC";
}