package org.clss.amaronmw.sap.converterEdi;

public class NamingDetail {
	
	private String name;
	
	private String additionalInformation;
	
	private String addressInformation;
	
	private String geographicLocation;
	
	private String AdministrativeContact;
	
	public NamingDetail() {
		super();
	}

	public NamingDetail(String name, String additionalInformation,
			String addressInformation, String geographicLocation,
			String administrativeContact) {
		super();
		this.name = name;
		this.additionalInformation = additionalInformation;
		this.addressInformation = addressInformation;
		this.geographicLocation = geographicLocation;
		AdministrativeContact = administrativeContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAddressInformation() {
		return addressInformation;
	}

	public void setAddressInformation(String addressInformation) {
		this.addressInformation = addressInformation;
	}

	public String getGeographicLocation() {
		return geographicLocation;
	}

	public void setGeographicLocation(String geographicLocation) {
		this.geographicLocation = geographicLocation;
	}

	public String getAdministrativeContact() {
		return AdministrativeContact;
	}

	public void setAdministrativeContact(String administrativeContact) {
		AdministrativeContact = administrativeContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((AdministrativeContact == null) ? 0 : AdministrativeContact
						.hashCode());
		result = prime
				* result
				+ ((additionalInformation == null) ? 0 : additionalInformation
						.hashCode());
		result = prime
				* result
				+ ((addressInformation == null) ? 0 : addressInformation
						.hashCode());
		result = prime
				* result
				+ ((geographicLocation == null) ? 0 : geographicLocation
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamingDetail other = (NamingDetail) obj;
		if (AdministrativeContact == null) {
			if (other.AdministrativeContact != null)
				return false;
		} else if (!AdministrativeContact.equals(other.AdministrativeContact))
			return false;
		if (additionalInformation == null) {
			if (other.additionalInformation != null)
				return false;
		} else if (!additionalInformation.equals(other.additionalInformation))
			return false;
		if (addressInformation == null) {
			if (other.addressInformation != null)
				return false;
		} else if (!addressInformation.equals(other.addressInformation))
			return false;
		if (geographicLocation == null) {
			if (other.geographicLocation != null)
				return false;
		} else if (!geographicLocation.equals(other.geographicLocation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
