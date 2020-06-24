/*
 * package it.sincrono.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import it.sincrono.services.ManagerService; import
 * it.sincrono.services.exceptions.ServiceException;
 * 
 * public class AccessoBadgeController {
 * 
 * 
 * @Autowired ManagerService managerservice;
 * 
 * 
 * 
 * @RequestMapping(value = "/accessoBadge/matricola/{matricola}/{data}", method
 * = RequestMethod.GET, produces = "application/json") public @ResponseBody
 * HttpEntity<AccessoBadgeListResponse>
 * getByMatricola(@PathVariable("matricola") Integer matricola) {
 * 
 * HttpEntity<AccessoBadgeListResponse> httpEntity = null;
 * 
 * AccessoBadgeListResponse accessoBadgeListResponse = new
 * AccessoBadgeListResponse();
 * 
 * try { List<AccessoBadge> accessiBadge =
 * managerservice.getListaAccessiBadgeByMatricola(matricola);
 * 
 * accessoBadgeListResponse.setList(accessiBadge);
 * accessoBadgeListResponse.setEsito(new Esito());
 * 
 * httpEntity = new
 * HttpEntity<AccessoBadgeListResponse>(accessoBadgeListResponse);
 * 
 * } catch (ServiceException e) {
 * 
 * badgeListResponse.setEsito(new Esito(e.getMessage())); httpEntity = new
 * HttpEntity<AccessoBadgeListResponse>(accessoBadgeListResponse); }
 * 
 * return httpEntity; }
 * 
 * }
 */
