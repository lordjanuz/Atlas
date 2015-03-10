package com.januz.atlas;

public class PlantaDto {

	// --------------------------------------------------------------------------
	// Attributes
	// --------------------------------------------------------------------------
	private int id;
	private String commonName;
	private String scientificName;
	private String family;
	private String description;

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public PlantaDto(int id, String commonName, String cientificName,
			String description, String family) {
		this.id = id;
		this.commonName = commonName;
		this.scientificName = cientificName;
		this.setFamily(family);
		this.description = description;
	}
	public PlantaDto(String commonName, String cientificName,
			String description, String family) {
		this.commonName = commonName;
		this.scientificName = cientificName;
		this.setFamily(family);
		this.description = description;
	}

	public PlantaDto() {

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
		return scientificName;
	}

	public void setCientificName(String cientificName) {
		this.scientificName = cientificName;
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
