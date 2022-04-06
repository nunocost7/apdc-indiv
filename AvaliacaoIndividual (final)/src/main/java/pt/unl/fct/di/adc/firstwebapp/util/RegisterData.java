package pt.unl.fct.di.adc.firstwebapp.util;

import pt.unl.fct.di.adc.firstwebapp.resources.LoginResource;

import java.util.logging.Logger;

public class RegisterData {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());
	private static final String INVALID = "INVALIDO";

	// mandatory
	private String username;
	private String name;
	private String email;
	private byte[] password;
	private byte[] confirmation;

	// optional
	private String phone;
	private String mobilePhone;
	private String address;
	private String profile;
	private String nif;
	private String role;
	private String status;

	public RegisterData() {

	}

	public RegisterData(String username, String name, String email, byte[] password, byte[] confirmation) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmation = confirmation;

	}

	// GETS AND SETS
	// TODO check gets

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public byte[] getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public String getNIF() {
		return nif;
	}

	// TODO: Check these ones

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// PRIVATE METHODS

	/*
	 * checks if the username and password match the requirements
	 */
	public boolean validRegistration() {

		if (username.isBlank() || password.length == 0) {
			return false;
		}
		return true;
	}

	/*
	 * checks if the email matches the correct format: <string>@<string>.dom
	 */
	public boolean checkEmailFormat() {
		// TODO: complete
		return true;
	}

	/*
	 * sets the optional user data
	 */
	public void setData(RegisterData data) {
		// TODO check role & profile

		if (data.phone != null) {
			this.phone = data.phone;
		} else {
			this.phone = INVALID;
		}

		if (data.mobilePhone != null) {
			this.mobilePhone = data.mobilePhone;
		} else {
			this.mobilePhone = INVALID;
		}

		if (data.address != null) {
			this.address = data.address;
		} else {
			this.address = INVALID;
		}

		if (data.nif != null) {
			this.nif = data.nif;
		} else {
			this.nif = INVALID;
		}

		// TODO check profile - publico ou privado
		if (data.profile != null) {
			this.profile = data.profile;
		} else {
			this.profile = INVALID;
		}

	}

	public boolean checkPassword() {
		return password.equals(confirmation);
	}

}
