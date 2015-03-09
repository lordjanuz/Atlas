package com.januz.test;

import org.junit.After;
import org.junit.Test;

import com.januz.atlas.PlantaDao;
import com.januz.atlas.PlantaDto;
import com.januz.atlas.Session;

public class AltasTest {
	Session session = new Session();
	PlantaDao dao = new PlantaDao();
	@Test
	public void ListarPlantas() {
		dao.listPlanta();
	}

	@Test
	public void getPlantaByCientificName() {
		String nombreComun = "Pehuen";
		String nombreCientifico = "Araucaria araucana";
		String familia = " 	Araucariaceae";
		String descripcion = "El nombre del género deriva de la región de Arauco, pues la especie Araucaria araucana crece en ambas cordilleras de "
				+ "esta zona y los pehuenches (\"gente de la araucaria\"), integrantes del pueblo mapuche, cosechan las semillas extensivamente para"
				+ " el alimento. Muchos lo llaman \"pino\", a pesar de que su relación con los pinos (Pinus) es muy lejana.";
		PlantaDto planta = new PlantaDto(nombreComun, nombreCientifico,
				descripcion, familia);
		dao.getPlantaByCientificName(planta);
	}

	@Test
	public void getPlantaById() {
		
		dao.getPlantaById("6");
		
	}

	@Test
	public void createPlanta() throws Exception {
		// Prepare
		String nombreComun = "Pehuen";
		String nombreCientifico = "Araucaria araucana";
		String familia = " 	Araucariaceae";
		String descripcion = "El nombre del género deriva de la región de Arauco, pues la especie Araucaria araucana crece en ambas cordilleras de "
				+ "esta zona y los pehuenches (\"gente de la araucaria\"), integrantes del pueblo mapuche, cosechan las semillas extensivamente para"
				+ " el alimento. Muchos lo llaman \"pino\", a pesar de que su relación con los pinos (Pinus) es muy lejana.";
		PlantaDto planta = new PlantaDto(nombreComun, nombreCientifico,
				descripcion, familia);
		Session con = new Session();

		// Perfom
		
		dao.createPlanta(planta);
		
		// Assert
//		assertThat(planta.getCommonName()).isEqualTo(nombreComun);
//		assertThat(planta.getCientificName()).isEqualTo(nombreCientifico);
//		assertThat(planta.getDescription()).isEqualTo(descripcion);
	}

	@Test
	public void deletePlanta() throws Exception {
		// Prepare
		
		String nombreCientifico = "Araucaria araucana";
		Session con = new Session();

		// Perfom
		dao.deletePlanta(nombreCientifico);
		
		// Assert
//		assertThat(planta.getCommonName()).isEqualTo(nombreComun);
//		assertThat(planta.getCientificName()).isEqualTo(nombreCientifico);
//		assertThat(planta.getDescription()).isEqualTo(descripcion);
	}
	@After
	public void exit() {
		session.close();
	}
	// --------------------------------------------------------------------------
	// Private Methods
	// --------------------------------------------------------------------------
	// private PlantaManager plantaManager;
}
