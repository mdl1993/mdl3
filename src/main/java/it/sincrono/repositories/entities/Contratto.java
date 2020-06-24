package it.sincrono.repositories.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contratti")
public class Contratto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id = null;

	@ManyToOne
	@JoinColumn(name = "id_anagrafica", referencedColumnName = "id")
	private Anagrafica anagrafica = null;

	private transient String nomeAzienda = null;

	@Column(name = "matricola_utente")
	private String matricolaUtente = null;

	@ManyToOne
	@JoinColumn(name = "id_tipo_contratto", referencedColumnName = "id")
	private TipoContratto tipoContratto = null;

	@Column(name = "data_inizio")
	private Date dataInizio = null;

	@Column(name = "data_fine")
	private Date dataFine = null;

	@Column(name = "mansione")
	private String mansione = null;

	@ManyToOne
	@JoinColumn(name = "id_sede_lavoro", referencedColumnName = "id_provincia")
	private Provincia sedeLavoro = null;

	@Column(name = "ral")
	private Double ral = null;

	/**
	 * @param id
	 */
	public Contratto(Integer id) {
		super();
		this.id = id;
	}
}