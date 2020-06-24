package it.sincrono.controllers.beans.requests;

import it.sincrono.domain.AccessoBadge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccessoBadgeRequest extends GenericRequest{

	protected AccessoBadge accessoBadge;

	

}
