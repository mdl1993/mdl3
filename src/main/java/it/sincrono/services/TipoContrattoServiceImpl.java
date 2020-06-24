package it.sincrono.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.TipoContrattoRepository;
import it.sincrono.repositories.entities.TipoContratto;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class TipoContrattoServiceImpl implements TipoContrattoService{
	
	@Autowired
	private TipoContrattoRepository tipoRepository = null;

	@Override
    public Map<Integer, String> map() throws ServiceException
    {
         Map<Integer, String> tipi = new HashMap<Integer, String>();

        try {
            for(TipoContratto tipo : tipoRepository.list()) {
                tipi.put(tipo.getId(), tipo.getDescrizione());
            }
        } catch(Exception e) {
            throw new ServiceException(e);
        }

        return tipi;
    }

}
