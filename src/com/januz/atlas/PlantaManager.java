package com.januz.atlas;

public class PlantaManager {

	public void creaPlanta(PlantaDto aPlanta) throws Exception {
		PlantaDao pla = new PlantaDao();
		pla.createPlanta(aPlanta);
	}

	public PlantaDto editaPlanta(String aPlantaId, PlantaDto aPlanta) {
		PlantaDto planta = new PlantaDto();
		PlantaDao daop = new PlantaDao();
		daop.getPlantaById(aPlantaId);
		planta.setCommonName(aPlanta.getCommonName());
		planta.setCientificName(aPlanta.getCientificName());
		planta.setDescription(aPlanta.getDescription());
		return planta;
	}

	public void eliminaPlanta(String aPlantaId) {
		PlantaDao daop = new PlantaDao();
		daop.deletePlanta(aPlantaId);
	}
}