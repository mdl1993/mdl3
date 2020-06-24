package it.sincrono.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import it.sincrono.controllers.exceptions.ControllerException;
import it.sincrono.controllers.forms.*;
import it.sincrono.controllers.validations.ContrattoValidator;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.entities.Contratto;
import it.sincrono.services.*;
import it.sincrono.services.exceptions.ServiceException;

@Controller
@RequestMapping(value = "/contratto")
public class ContrattoController {
	
	@Autowired 
	ProvinciaService provinciaService;

	@Autowired
	ContrattoService contrattoService;

	@Autowired
	AnagraficaService managerService;
	
	@Autowired
	TipoContrattoService tipoService;
	

	@Autowired
	private ContrattoValidator validator;

	@RequestMapping("/list")
	public String list(Model model) throws ControllerException {

		try {
			List<Contratto> contratti = contrattoService.getListaContratti();

			model.addAttribute("contratti", contratti);

		} catch (ServiceException e) {

			throw new ControllerException(e);

		}

		return "lista-contratto";
	}

	@RequestMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id, Model model) throws ControllerException {

		try {
			Contratto contratto = contrattoService.getContratto(id);

			model.addAttribute("contratto", contratto);

		} catch (ServiceException e) {

			throw new ControllerException(e);

		}

		return "dettaglio-contratto";
	}

	@RequestMapping("/openInsert")
	public String openInsert(Model model, @ModelAttribute ContrattoForm contrattoForm) throws ControllerException {

		Map<Integer, String> anagrafiche = new HashMap<Integer, String>();

		try {
			Map<Integer, String> tipi = tipoService.map();
			Map<Integer, String> province = provinciaService.map();

				List<Anagrafica> listaAnagrafiche = managerService.getListaAnagrafica();
				for (Anagrafica elemento : listaAnagrafiche) {
					anagrafiche.put(elemento.getId(), elemento.getNome() + " " + elemento.getCognome());

					
				}
				
				
			

			model.addAttribute("contrattoForm", contrattoForm);
			model.addAttribute("province", province);
			model.addAttribute("anagrafiche", anagrafiche);
			model.addAttribute("tipi", tipi);
		} catch (ServiceException e) { //
			e.printStackTrace();
		}
		return "nuovo-contratto";
	}

	@RequestMapping("/insert")
	public String insert(Model model, @ModelAttribute ContrattoForm contrattoForm, BindingResult result)
			throws ControllerException {

		
		Map<Integer, String> anagrafiche = new HashMap<Integer, String>();
		String returnValue = "redirect:/contratto/list";

		try {
			validator.validate(contrattoForm.getContratto(), result);

			if (result.hasErrors()) {
				Map<Integer, String> tipi = tipoService.map();
				Map<Integer, String> province = provinciaService.map();

				List<Anagrafica> listaAnagrafiche = managerService.getListaAnagrafica();
				for (Anagrafica elemento : listaAnagrafiche) {
					anagrafiche.put(elemento.getId(), elemento.getNome() + " " + elemento.getCognome());
				}

				model.addAttribute("errors", result);
				model.addAttribute("province", province);
				model.addAttribute("anagrafiche", anagrafiche);
				model.addAttribute("tipi", tipi);

				return "nuovo-contratto";

			}

			contrattoService.insert(contrattoForm.getContratto());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}

	@RequestMapping("/openUpdate/{id}")
	public String openUpdate(@PathVariable("id") Integer id, Model model) throws ControllerException {
		
		Map<Integer, String> anagrafiche = new HashMap<Integer, String>();

		try {
			Map<Integer, String> tipi = tipoService.map();
			Map<Integer, String> province = provinciaService.map();

			List<Anagrafica> listaAnagrafiche = managerService.getListaAnagrafica();
			for (Anagrafica elemento : listaAnagrafiche) {
				anagrafiche.put(elemento.getId(), elemento.getNome() + " " + elemento.getCognome());
			}

			ContrattoForm contrattoForm = new ContrattoForm(contrattoService.getContratto(id));
			model.addAttribute("contrattoForm", contrattoForm);
			model.addAttribute("province", province);
			model.addAttribute("anagrafiche", anagrafiche);
			model.addAttribute("tipi", tipi);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "modifica-contratto";
	}

	@RequestMapping("/update")
	public String update(Model model, @ModelAttribute ContrattoForm contrattoForm, BindingResult result)
			throws ControllerException {

		String returnValue = "redirect:/contratto/get/" + contrattoForm.getContratto().getId();

		Map<Integer, String> anagrafiche = new HashMap<Integer, String>();

		try {

			validator.validate(contrattoForm.getContratto(), result);
			Map<Integer, String> tipi = tipoService.map();
			Map<Integer, String> province = provinciaService.map();

			List<Anagrafica> listaAnagrafiche = managerService.getListaAnagrafica();
			for (Anagrafica elemento : listaAnagrafiche) {
				anagrafiche.put(elemento.getId(), elemento.getNome() + " " + elemento.getCognome());
			}


			if (result.hasErrors()) {

				model.addAttribute("errors", result);
				model.addAttribute("province", province);
				model.addAttribute("anagrafiche", anagrafiche);
				model.addAttribute("tipi", tipi);

				return "modifica-contratto";

			}

			for (Integer id : anagrafiche.keySet()) {
				System.out.println(id);
				System.out.println(anagrafiche.get(id));
			}

			System.out.println(contrattoForm.getContratto());

			contrattoService.update(contrattoForm.getContratto());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) throws ControllerException {

		String returnValue = "redirect:/contratto/list";

		try {
			contrattoService.delete(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}

}
