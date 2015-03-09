package com.januz.atlas;

public class Planta {

	// --------------------------------------------------------------------------
	// Attributes
	// --------------------------------------------------------------------------
	private int id;
	private String commonName;
	private String cientificName;
	private String family;
	private String description;

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public Planta(int id, String commonName, String cientificName,
			String description, String family) {
		this.id = id;
		this.commonName = commonName;
		this.cientificName = cientificName;
		this.setFamily(family);
		this.description = description;
	}

	public Planta() {
		
	}

	// --------------------------------------------------------------------------
	// Getters and Setters
	// --------------------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
