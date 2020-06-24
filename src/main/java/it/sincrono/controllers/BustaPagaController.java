package it.sincrono.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import it.sincrono.controllers.beans.a.Esito;
import it.sincrono.controllers.beans.requests.AccessoBadgeRequest;
import it.sincrono.controllers.beans.responses.BadgeListResponse;
import it.sincrono.controllers.beans.responses.BadgeResponse;
import it.sincrono.controllers.exceptions.ControllerException;
import it.sincrono.controllers.forms.AccessoBadgeForm;
import it.sincrono.controllers.forms.BustaPagaForm;
import it.sincrono.domain.AccessoBadge;
import it.sincrono.services.AnagraficaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/bustaPaga")
public class BustaPagaController extends ApplicationController {

	@Autowired
	AnagraficaService managerservice;

	private String URL = "http:/localhost:8080/BadgeRest/";

	@RequestMapping("/openSearch")
	public String ricerca(Model model, @ModelAttribute BustaPagaForm bustaPagaForm) throws ControllerException {

		model.addAttribute("bustaPagaForm", new BustaPagaForm());

		return "cerca-bustaPaga";

	}

	/*
	 * @RequestMapping(value = "/badge", method = RequestMethod.GET, produces =
	 * "application/json") public @ResponseBody HttpEntity<BadgeListResponse>
	 * getPresences(@RequestBody BadgeRequest badgeRequest) throws
	 * ControllerException {
	 * 
	 * HttpEntity<BadgeListResponse> httpEntity = null;
	 * 
	 * BadgeListResponse badgeListResponse = new BadgeListResponse();
	 * 
	 * try { List<Badge> listaBadge = null;
	 * 
	 * badgeListResponse.setList(listaBadge); badgeListResponse.setEsito(new
	 * Esito());
	 * 
	 * httpEntity = new HttpEntity<AnagraficaResponse>(badgeListResponse);
	 * 
	 * } catch (ServiceException e) {
	 * 
	 * badgeListResponse.setEsito(new Esito(e.getMessage())); httpEntity = new
	 * HttpEntity<badgeListResponse>(badgeListResponse);
	 * 
	 * }
	 * 
	 * return httpEntity;
	 * 
	 * }
	 */
	
	

	@RequestMapping("/elabora")
	public String elabora(@ModelAttribute AccessoBadgeForm accessoBadgeForm, Model model) throws ControllerException {

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			AccessoBadgeRequest accessoRequest = new AccessoBadgeRequest();
			
			accessoRequest.setAccessoBadge(accessoBadgeForm.getAccessoBadge());

			HttpEntity<AccessoBadgeRequest> entity = new HttpEntity<AccessoBadgeRequest>(accessoRequest, headers);

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<BadgeListResponse> badgeListResponse = restTemplate.exchange(
					URL, HttpMethod.POST, entity, BadgeListResponse.class);
			
			badgeListResponse.getBody().getListaAccessi();
			
			//Calcolo busta paga

		} catch (Exception e) {
			
			

		}

		return "busta-paga";

	}
	
	@RequestMapping(value = "/list")
	public String getALL(Model model, @ModelAttribute BustaPagaForm bustaPagaForm) throws ControllerException {
		
		try {
			AccessoBadge badge = new AccessoBadge();
			badge.setMatricolaUtente(bustaPagaForm.getContratto().getMatricolaUtente());
			badge.setDataOrario(bustaPagaForm.getContratto().getDataFine());
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<AccessoBadgeRequest> entity = new HttpEntity<AccessoBadgeRequest>(new AccessoBadgeRequest(badge), headers);
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<BadgeResponse> badgeResponse = restTemplate.exchange(URL, HttpMethod.POST, entity, BadgeResponse.class);
			
			Esito esito = badgeResponse.getBody().getEsito();
			
		} catch (Exception e) {
			
			throw new ControllerException(e);
			
		}
		
		return "busta-paga";
		
		
	}


}
