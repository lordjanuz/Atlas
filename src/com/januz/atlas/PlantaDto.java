package com.januz.atlas;

public class PlantaDto {

	// --------------------------------------------------------------------------
	// Attributes
	// --------------------------------------------------------------------------

	private String commonName;
	private String cientificName;
	private String family;
	private String description;

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public PlantaDto(String commonName, String cientificName, String family, String  description) {
		this.commonName = commonName;
		this.cientificName = cientificName;
		this.family = family;
		this.description = description;
	}

	public PlantaDto() {

	}

	// --------------------------------------------------------------------------
	// Getters and Setters
	// --------------------------------------------------------------------------

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getCientificName() {
		return cientificName;
	}

	public void setCientificName(String cientificName) {
		this.cientificName = cientificName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

}
