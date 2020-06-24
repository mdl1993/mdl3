package it.sincrono.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import it.sincrono.controllers.beans.a.Esito;
import it.sincrono.controllers.beans.responses.AnagraficaResponse;
import it.sincrono.controllers.exceptions.ControllerException;
import it.sincrono.controllers.forms.AnagraficaForm;
import it.sincrono.controllers.validations.AnagraficaValidator;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.services.AnagraficaService;
import it.sincrono.services.ProvinciaService;
import it.sincrono.services.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/anagrafica")
public class AnagraficaController {

	
	@Autowired 
	AnagraficaService anagraficaService;
	
	@Autowired 
	ProvinciaService provinciaService;
	 
	
	@Autowired
	private AnagraficaValidator validator;
	
	
	  @RequestMapping(value= "/anagrafica/{id}", method = RequestMethod.POST, produces = "application/json") public @ResponseBody
	  HttpEntity<AnagraficaResponse> get(@PathVariable("id") Integer ID) throws ControllerException {
	  
	  HttpEntity<AnagraficaResponse> httpEntity = null;
	  
	  AnagraficaResponse anagraficaResponse = new AnagraficaResponse();
	  
	  try { 
		  Anagrafica anagrafica = new Anagrafica();
	  
	  anagraficaResponse.setAnagrafica(anagrafica); 
	  anagraficaResponse.setEsito(new Esito());
	  
	  httpEntity = new HttpEntity<AnagraficaResponse>(anagraficaResponse);
	  
	  
	  } catch (Exception e) {
	  
	  anagraficaResponse.setEsito(new Esito(e.getMessage())); 
	  httpEntity = new
	  HttpEntity<AnagraficaResponse>(anagraficaResponse); }
	  
	  
	  return httpEntity; 
	  
	  }
	 
	
	
	
	
	@RequestMapping("/list")
	public String list(Model model) throws ControllerException {

		try {
			log.info("START invocation getAll() of controller layer");

			
			List<Anagrafica> anagrafiche = anagraficaService.getListaAnagrafica();

			model.addAttribute("anagrafiche", anagrafiche);

		} catch (ServiceException e) {

			throw new ControllerException(e);

		}

		return "lista-anagrafica";
	}

	@RequestMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id, Model model) throws ControllerException {

		try {
			Anagrafica anagrafica = anagraficaService.getAnagrafica(id);

			model.addAttribute("anagrafica", anagrafica);

		} catch (ServiceException e) {

			throw new ControllerException(e);

		}

		return "dettaglio-anagrafica";
	}

	@RequestMapping("/openInsert")

	public String openInsert(Model model, @ModelAttribute AnagraficaForm anagraficaForm) throws ControllerException {

		

		try {
			Map<Integer, String> province = provinciaService.map();

			model.addAttribute("anagraficaForm", anagraficaForm);
			model.addAttribute("province", province);
		} catch (ServiceException e) { //
			e.printStackTrace();
		}
		return "nuova-anagrafica";
	}

	/*
	 * public String openInsert(Model model, @ModelAttribute AnagraficaForm
	 * anagraficaForm) throws ControllerException {
	 * 
	 * try { List<Provincia> province = managerservice.caricaProvincie();
	 * model.addAttribute("anagraficaForm", new AnagraficaForm());
	 * model.addAttribute("province", province); } catch (ServiceException e) {
	 * throw new ControllerException(e); }
	 * 
	 * return "nuova-anagrafica"; }
	 */
	@RequestMapping("/insert")
	public String insert(Model model, @ModelAttribute AnagraficaForm anagraficaForm, BindingResult result)
			throws ControllerException {

		String returnValue = "redirect:/anagrafica/list";

		try {
			validator.validate(anagraficaForm.getAnagrafica(), result);

			if (result.hasErrors()) {
				Map<Integer, String> province = provinciaService.map();

				model.addAttribute("errors", result);
				model.addAttribute("province", province);

				return "nuova-anagrafica";
			}

			anagraficaService.insert(anagraficaForm.getAnagrafica());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}

	@RequestMapping("/openUpdate/{id}")
	public String openUpdate(@PathVariable("id") Integer id, Model model) throws ControllerException {

	
		try {
			Map<Integer, String> province = provinciaService.map();
			
			AnagraficaForm anagraficaForm = new AnagraficaForm(anagraficaService.getAnagrafica(id));

			model.addAttribute("anagraficaForm", anagraficaForm);
			model.addAttribute("province", province);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "modifica-anagrafica";
	}

	@RequestMapping("/openUpdate/update")
	public String update(Model model, @ModelAttribute AnagraficaForm anagraficaForm, BindingResult result)
			throws ControllerException {

		String returnValue = "redirect:/anagrafica/get/"+ anagraficaForm.getAnagrafica().getId();

		try {
			validator.validate(anagraficaForm.getAnagrafica(), result);

			if (result.hasErrors()) {

				Map<Integer, String> province = provinciaService.map();

				model.addAttribute("errors", result);
				model.addAttribute("province", province);

				return "modifica-anagrafica";
			}

			anagraficaService.update(anagraficaForm.getAnagrafica());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {

		String returnValue = "redirect:/anagrafica/list";

		try {
			anagraficaService.delete(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}
}