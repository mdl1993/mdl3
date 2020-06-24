package it.sincrono.repositories.impl;

import javax.persistence.*;

import it.sincrono.repositories.BaseCustomRepository;

public abstract class BaseRepositoryImpl implements BaseCustomRepository
{
	@PersistenceContext
	protected EntityManager entityManager = null;

	/**
	 * @param entityManager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}