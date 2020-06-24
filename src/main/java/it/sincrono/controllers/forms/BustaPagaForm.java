package it.sincrono.controllers.forms;

import it.sincrono.domain.*;
import it.sincrono.repositories.entities.Contratto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BustaPagaForm {

	protected BustaPaga bustaPaga;
	protected Contratto contratto;
	protected Azienda azienda;

	
	

}
