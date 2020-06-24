package it.sincrono.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.sincrono.repositories.AnagraficaRepository;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.exceptions.RepositoryException;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class AnagraficaServiceImpl implements AnagraficaService
{
    @Autowired
	private AnagraficaRepository anagraficaRepository = null;

    @Override
	public List<Anagrafica> getListaAnagrafica() throws ServiceException {
		List<Anagrafica> anagrafiche = null;

		try {
			anagrafiche = anagraficaRepository.list();
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return anagrafiche;
	}
    
    @Override
	public List<Anagrafica> search(Anagrafica anagrafica) throws ServiceException {
    	List<Anagrafica> anagrafiche = null;
    	
    	try {
			anagrafiche = anagraficaRepository.search(anagrafica);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return anagrafiche;
	}

	@Override
	public Anagrafica getAnagrafica(Integer id) throws ServiceException {
		Anagrafica anagrafica = null;

		try {
			anagrafica = anagraficaRepository.findById(id).get();
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return anagrafica;
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Integer insert(Anagrafica anagrafica) throws ServiceException {

		try {
			anagrafica = anagraficaRepository.saveAndFlush(anagrafica);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return anagrafica.getId();
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void update(Anagrafica anagrafica) throws ServiceException {

		try {
            Anagrafica currentAnagrafica = anagraficaRepository.findById(anagrafica.getId()).get();

            currentAnagrafica.setNome(anagrafica.getNome());
            currentAnagrafica.setCognome(anagrafica.getCognome());
            currentAnagrafica.setCodiceFiscale(anagrafica.getCodiceFiscale());
            currentAnagrafica.setProvinciaNascita(anagrafica.getProvinciaNascita());
            currentAnagrafica.setEta(anagrafica.getEta());
            currentAnagrafica.setSesso(anagrafica.getSesso());
            currentAnagrafica.setCategoriaProtetta(anagrafica.getCategoriaProtetta());
            currentAnagrafica.setCurriculum(anagrafica.getCurriculum());

            anagraficaRepository.saveAndFlush(currentAnagrafica);

        } catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer id) throws ServiceException {

		try {
			anagraficaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	

}