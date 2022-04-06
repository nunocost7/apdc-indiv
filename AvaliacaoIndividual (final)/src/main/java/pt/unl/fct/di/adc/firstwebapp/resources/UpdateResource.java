package pt.unl.fct.di.adc.firstwebapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.unl.fct.di.adc.firstwebapp.util.UpdateData;

@Path("/update")
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateResource {

	public UpdateResource() {

	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(UpdateData data) {
		// TODO Auto-generated method stub

		return null;
	}
}
