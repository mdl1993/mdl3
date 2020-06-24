package it.sincrono.services;

import java.util.Map;
import it.sincrono.services.exceptions.ServiceException;

public interface ProvinciaService {
	

    public Map<Integer, String> map() throws ServiceException;

}
