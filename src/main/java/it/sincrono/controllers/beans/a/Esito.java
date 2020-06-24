package it.sincrono.controllers.beans.a;

import lombok.*;

@Data
@NoArgsConstructor
public class Esito {

	/**
	 * @param target
	 */
	public Esito(String target) {
		this.code = -1;
		this.target = target;
	}
	
	/**
	 * @param code
	 * @param target
	 */
	public Esito(Integer code, String target) {
		this.code = code;
		this.target = target;
	}

	// Internal code
	private Integer code = 0;

	// Key for identifing the text of a static message
	private String target = null;

	// String arguments to be associated with the key
	private String[] args = null;
}