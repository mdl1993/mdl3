package it.sincrono.controllers.validations;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.sincrono.repositories.entities.Contratto;

@Component
public class ContrattoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return Contratto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Contratto contratto = (Contratto) target;

		

		if (contratto.getMansione() == null || contratto.getMansione().equals("")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contratto.mansione", "errors.required",
					new Object[] { "Mansione" });
		}

		if (contratto.getDataFine() == null /* || anagrafica.getDataFine().equals("") */) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contratto.dataFine", "errors.required",
					new Object[] { "Data Fine" });
		}

		

		if (contratto.getDataInizio() == null /* || anagrafica.getDataInizio().equals("") */) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contratto.dataInizio", "errors.required",
					new Object[] { "Data Inizio" });
		}

		if (contratto.getRal() == null ) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contratto.RAL", "errors.required",
					new Object[] { "RAL" });
		}

	}

}
