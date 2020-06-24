package it.sincrono.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import it.sincrono.repositories.AnagraficaRepository;
import it.sincrono.repositories.ContrattoRepository;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.entities.Contratto;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class ContrattoServiceImpl implements ContrattoService {

	@Autowired
	private ContrattoRepository contrattoRepository = null;

	@Override
	public List<Contratto> getListaContratti() throws ServiceException {

		List<Contratto> contratti = null;

		try {
			contratti = contrattoRepository.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contratti;
	}

	@Override
	public Contratto getContratto(Integer id) throws ServiceException {

		Contratto contratto = null;

		try {
			contratto = contrattoRepository.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contratto;
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Integer insert(Contratto contratto) throws ServiceException {


		try {
			contratto = contrattoRepository.saveAndFlush(contratto);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return contratto.getId();
	}

	@Override
	public void update(Contratto contratto) throws ServiceException {

		try {
			Contratto currentContratto = contrattoRepository.findById(contratto.getId()).get();

			currentContratto.setAnagrafica(contratto.getAnagrafica());
			currentContratto.setMatricolaUtente(contratto.getMatricolaUtente());
			currentContratto.setTipoContratto(contratto.getTipoContratto());
			currentContratto.setDataInizio(contratto.getDataInizio());
			currentContratto.setDataFine(contratto.getDataFine());
			currentContratto.setMansione(contratto.getMansione());
			currentContratto.setSedeLavoro(contratto.getSedeLavoro());
			currentContratto.setRal(contratto.getRal());

			contrattoRepository.saveAndFlush(currentContratto);

        } catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer id) throws ServiceException {

		try {
		contrattoRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}



}
