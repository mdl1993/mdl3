package it.sincrono.services;

import java.util.List;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.services.exceptions.ServiceException;

public interface AnagraficaService {
	
    public List<Anagrafica> getListaAnagrafica() throws ServiceException;
    public Anagrafica getAnagrafica(Integer id) throws ServiceException;
    public Integer insert(Anagrafica anagrafica) throws ServiceException;
    public void update(Anagrafica anagrafica) throws ServiceException;
    public void delete(Integer id) throws ServiceException;
    public List<Anagrafica> search(Anagrafica anagrafica) throws ServiceException;
}