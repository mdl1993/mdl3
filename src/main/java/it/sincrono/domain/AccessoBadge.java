package it.sincrono.domain;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessoBadge {
	
	
	private Integer id;
	private String matricolaUtente;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "CET")
	private Date dataOrario;
	private Integer tipo;

}
