package pt.unl.fct.di.adc.firstwebapp.util;

public class LoginData {

	public String username;
	public String password;

	public LoginData() {

	}

	public LoginData(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}