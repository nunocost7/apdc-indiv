package pt.unl.fct.di.adc.firstwebapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Transaction;

import pt.unl.fct.di.adc.firstwebapp.util.RemoveData;

import java.util.logging.Logger;

@Path("/remove")
@Consumes(MediaType.APPLICATION_JSON)
public class RemoveResource {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());
	Datastore datastore;

	public RemoveResource() {

	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeUser(RemoveData data) {

		// TODO check conditions
		Transaction txn = datastore.newTransaction();

		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.getUsername());
			Entity user = txn.get(userKey);

			if (user == null) {
				txn.rollback();
				return Response.status(Status.NOT_FOUND).entity("User does not exists.").build();
			} else {

				// TODO
				// check if account to remove exist
				// check roles and permissions to delete

				return Response.ok("User deleted").build();
			}
		}

		finally {
			if (txn.isActive()) {
				txn.rollback();
			}
		}
	}
}
