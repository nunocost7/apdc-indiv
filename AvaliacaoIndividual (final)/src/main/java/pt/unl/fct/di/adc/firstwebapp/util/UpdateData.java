package pt.unl.fct.di.adc.firstwebapp.util;

public class UpdateData {

	private final String INVALID = "INVALIDO";

	private String phone;
	private String email;
	private String mobilePhone;
	private String address;
	private String name;
	private String nif;
	private byte[] password;
	private byte[] confirmation;

	public UpdateData() {

	}

	public UpdateData(String phone, String email, String mobilePhone, String address, String name, String nif,
			byte[] password, byte[] confirmation) {

		if (phone.isBlank()) {
			phone = INVALID;
		}
		setPhone(phone);

		if (email.isBlank()) {
			email = INVALID;
		}
		setEmail(email);

		if (mobilePhone.isBlank()) {
			mobilePhone = INVALID;
		}
		setMobilePhone(mobilePhone);

		if (address.isBlank()) {
			address = INVALID;
		}
		setAddress(address);

		if (name.isBlank()) {
			name = INVALID;
		}
		setName(name);

		if (nif.isBlank()) {
			nif = INVALID;
		}
		setNIF(nif);

		if (!(password.length == 0)) {
			setPassword(password);
		}

		if (!(confirmation.length == 0)) {
			setConfirmation(confirmation);
		}

	}

	public void changePassword(byte[] password, byte[] confirmation) {
		if (password.length > 0 && password.equals(confirmation)) {
			this.password = this.confirmation = password;
		}
	}

	public void setConfirmation(byte[] confirmation) {
		this.confirmation = confirmation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNIF(String nif) {
		this.nif = nif;
	}
}