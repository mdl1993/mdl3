package it.sincrono.controllers.forms;

import it.sincrono.repositories.entities.Contratto;

public class ContrattoForm {
	
	private Contratto contratto;

	public ContrattoForm(Contratto contratto) {
		super();
		this.contratto = contratto;
	}

	public ContrattoForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contratto getContratto() {
		return contratto;
	}

	public void setContratto(Contratto contratto) {
		this.contratto = contratto;
	}
	
	

}
