package it.sincrono.repositories.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anagrafiche")
public class Anagrafica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id = null;

	@Column(name = "nome")
	private String nome = null;

	@Column(name = "cognome")
	private String cognome = null;

	@Column(name = "codice_fiscale")
	private String codiceFiscale = null;

	@ManyToOne
	@JoinColumn(name = "id_provincia_nascita", referencedColumnName = "id_provincia")
	private Provincia provinciaNascita = null;

	@Column(name = "eta")
	private Integer eta = null;

	@Column(name = "sesso")
	private String sesso = null;

	@Column(name = "categoria_protetta")
	private Boolean categoriaProtetta = null;

	@Column(name = "curriculum")
	private String curriculum = null;

	/**
	 * @param id
	 */
	public Anagrafica(Integer id) {
		super();
		this.id = id;
	}
}