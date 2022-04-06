package pt.unl.fct.di.adc.firstwebapp.util;

import java.util.logging.Logger;

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

import pt.unl.fct.di.adc.firstwebapp.resources.LoginResource;

public class RemoveData {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());

	private String toDelete;
	private String deletor;
	private String username;

	public RemoveData() {

	}

	public boolean checkPermissions() {
		// TODO
		return true;
	}

	public String getUsername() {
		return username;
	}

}
