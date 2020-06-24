package it.sincrono.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.ProvinciaRepository;
import it.sincrono.repositories.entities.Provincia;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
	
	@Autowired
	private ProvinciaRepository provinciaRepository = null;

	@Override
    public Map<Integer, String> map() throws ServiceException
    {
         Map<Integer, String> province = new HashMap<Integer, String>();

        try {
            for(Provincia provincia : provinciaRepository.list()) {
                province.put(provincia.getIdProvincia(), provincia.getDescrizione());
            }
        } catch(Exception e) {
            throw new ServiceException(e);
        }

        return province;
    }

	

}
