package it.sincrono.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BustaPaga {
	
	protected Double importoLordo;
	protected Double imposte;
	protected Double importoNetto;

	
	

}
