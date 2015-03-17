package com.januz.test;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;

import com.januz.atlas.PlantaDao;
import com.januz.atlas.PlantaDto;
import com.januz.atlas.Session;

public class AltasTest {
	Session session = new Session();
	PlantaDao dao = new PlantaDao();

	@Test
	public void createPlanta() throws Exception {
		// Prepare
		String nombreComun = "Pehuen";
		String nombreCientifico = "Araucaria araucana33";
		String familia = "Araucariaceae";
		String descripcion = "El nombre del g�nero deriva de la regi�n de Arauco.";
		PlantaDto planta = new PlantaDto(nombreComun, nombreCientifico,
				familia, descripcion);

		// Perfom

		dao.createPlanta(planta);

		// Assert
		assertThat(dao.getPlantaByCientificName(nombreCientifico)).isEqualTo(
				planta);
	}

	@Test
	public void ListarPlantas() {
		dao.listPlanta();
	}

	@Test
	public void getPlantaByCientificName() {
		String nombreComun = "Pehuen";
		String nombreCientifico = "Araucaria araucana";
		String familia = "Araucariaceae";
		String descripcion = "El nombre del g�nero deriva de la regi�n de Arauco";
		PlantaDto planta = new PlantaDto(nombreComun, nombreCientifico,
				descripcion, familia);
		dao.getPlantaByCientificName(planta.getScientificName());
	}

	@Test
	public void getPlantaById() {
		// Perform
		PlantaDto aPlanta = dao.getPlantaById("6");
		// Assert
		assertThat(aPlanta.getId()).isEqualTo(6);
	}

	@Test
	public void deletePlanta() throws Exception {
		// Prepare

		String nombreCientifico = "Araucaria araucana";

		// Perfom
		dao.deletePlanta(nombreCientifico);

		// Assert
		// assertThat(planta.getCommonName()).isEqualTo(nombreComun);
		// assertThat(planta.getCientificName()).isEqualTo(nombreCientifico);
		// assertThat(planta.getDescription()).isEqualTo(descripcion);
	}

	@Test
	public void editPlanta() {
		// Prepare
		String nombreComun = "nombre editado";
		String nombreCientifico = "Magnolia liliflora2";
		String familia = "familia editada";
		String descripcion = "Descripcion editada";
		PlantaDto aPlanta = new PlantaDto(nombreComun, nombreCientifico,
				descripcion, familia);
		
		// Perfom
		dao.editaPlanta(aPlanta);

		// Assert
		assertThat(aPlanta.getCommonName()).isEqualTo(nombreComun);
		assertThat(aPlanta.getScientificName()).isEqualTo(nombreCientifico);
		assertThat(aPlanta.getFamily()).isEqualTo(familia);
		assertThat(aPlanta.getDescription()).isEqualTo(descripcion);
	}

	@Test
	@After
	public void exit() {
		session.close();
	}
}
