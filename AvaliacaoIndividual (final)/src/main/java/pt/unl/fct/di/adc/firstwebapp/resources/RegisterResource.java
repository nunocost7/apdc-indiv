package pt.unl.fct.di.adc.firstwebapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.appengine.repackaged.org.apache.commons.codec.digest.DigestUtils;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;

import pt.unl.fct.di.adc.firstwebapp.util.RegisterData;

@Path("/regist")
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterResource {

	Datastore datastore;

	public RegisterResource() {

	}

	@POST
	@Path("/regist")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistration(RegisterData data) {
		// LOG.fine("Attempt to register user: " + data.getUsername());

		// checks if the username and password match the requirements
		if (!data.validRegistration()) {
			return Response.status(Status.BAD_REQUEST).entity("Missing or wrong parameter.").build();
		}

		// checks if the email matches the correct format
		if (!data.checkEmailFormat()) {
			return Response.status(Status.BAD_REQUEST).entity("Wrong format for email.").build();
		}

		// checks if the password is equal to its confirmation
		if (!data.checkPassword()) {// .equals(data.confirmation)) {
			return Response.status(Status.BAD_REQUEST).entity("Password and confirmation don't match").build();
		}

		Transaction txn = datastore.newTransaction();

		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.getUsername());
			Entity user = txn.get(userKey);

			if (user != null) {
				txn.rollback();
				return Response.status(Status.CONFLICT).entity("User already exists.").build();
			} else {

				Query<Key> query = Query.newKeyQueryBuilder().setFilter(PropertyFilter.eq("user_role", "SU"))
						.setKind("User").build();
				QueryResults<Key> users = datastore.run(query);

				// sets the optional user data
				data.setData(data);

				// if it has no SU yet, it creates one
				if (users.hasNext()) {
					user = Entity.newBuilder(userKey).set("user_name", data.getName())
							.set("user_pwd", DigestUtils.sha512Hex(data.getPassword()))
							.set("user_email", data.getEmail()).set("user_creation_time", Timestamp.now())
							.set("phone", data.getPhone()).set("mobile_phone", data.getMobilePhone())
							.set("address", data.getAddress()).set("nif", data.getNIF()).set("status", "INATIVO")
							.set("role", "SU").build();
				}

				else {
					user = Entity.newBuilder(userKey).set("user_name", data.getName())
							.set("user_pwd", DigestUtils.sha512Hex(data.getPassword()))
							.set("user_email", data.getEmail()).set("user_creation_time", Timestamp.now())
							.set("phone", data.getPhone()).set("mobile_phone", data.getMobilePhone())
							.set("address", data.getAddress()).set("nif", data.getNIF()).set("status", "INATIVO")
							.set("role", "USER").build();
				}
				txn.add(user);
				txn.commit();
				return Response.ok("User registered " + data.getUsername()).build();
			}
		}

		finally {

			if (txn.isActive()) {
				txn.rollback();
			}
		}
	}

}
