package com.januz.atlas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantaDao {
	Session session = new Session();

	public void createPlanta(PlantaDto aPlanta) throws Exception {
		try {
			PreparedStatement st = session
					.connection()
					.prepareStatement(
							"insert into PLANTA (COMMONNAME, SCIENTIFICNAME, FAMILY, DESCRIPTION) values (?,?,?,?)");
			st.setString(1, aPlanta.getCommonName());
			st.setString(2, aPlanta.getScientificName());
			st.setString(3, aPlanta.getFamily());
			st.setString(4, aPlanta.getDescription());
			st.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Hubo un problema al Crear la nueva Planta...");
		}

	}

	public List<PlantaDto> listPlanta() {
		ResultSet result = null;
		List<PlantaDto> aPlantas= new ArrayList();
		try {
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA");
			result = st.executeQuery();
			while (result.next()) {
				PlantaDto aPlanta = armaPlanta(result);
				
				System.out.print("ID: ");
				System.out.println(aPlanta.getId());

				System.out.print("Nombre comun: ");
				System.out.println(aPlanta.getCommonName());

				System.out.print("Nombre Cientifico: ");
				System.out.println(aPlanta.getScientificName());

				System.out.print("Familia: ");
				System.out.println(aPlanta.getFamily());

				System.out.print("Descripcion: ");
				System.out.println(aPlanta.getDescription());

				System.out.println("=======================");
				aPlantas.add(aPlanta);
				
			}
			return aPlantas;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
		return null;
	}

	public PlantaDto getPlantaByCientificName(String scientificName) {
		ResultSet result = null;
		try {
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA where SCIENTIFICNAME = ?");
			st.setString(1, scientificName);
			result = st.executeQuery();
			while (result.next()) {
				PlantaDto aPlanta2 = armaPlanta(result);
				
				System.out.print("ID: ");
				System.out.println(aPlanta2.getId());

				System.out.print("Nombre comun: ");
				System.out.println(aPlanta2.getCommonName());

				System.out.print("Nombre Cientifico: ");
				System.out.println(aPlanta2.getScientificName());

				System.out.print("Familia: ");
				System.out.println(aPlanta2.getFamily());

				System.out.print("Descripcion: ");
				System.out.println(aPlanta2.getDescription());

				System.out.println("=======================");
				return aPlanta2;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
		return null;
	}

	public void deletePlanta(String nombre) {
		@SuppressWarnings("unused")
		ResultSet result = null;
		try {
			PreparedStatement st = session.connection().prepareStatement(
					"delete from PLANTA where CIENTIFICNAME = ?");
			st.setString(1, nombre);
			result = st.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
	}

	public PlantaDto getPlantaById(String anId) {
		ResultSet result = null;
		try {
			
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA where ID = ?");
			st.setString(1, anId);
			result = st.executeQuery();
			while (result.next()) {
				
				PlantaDto aPlanta = armaPlanta(result);
				
				System.out.print("ID: ");
				System.out.println(result.getInt("id"));

				System.out.print("Nombre comun: ");
				System.out.println(aPlanta.getCommonName());

				System.out.print("Nombre Cientifico: ");
				System.out.println(aPlanta.getScientificName());

				System.out.print("Familia: ");
				System.out.println(aPlanta.getFamily());

				System.out.print("Descripcion: ");
				System.out.println(aPlanta.getDescription());
				System.out.println("=======================");
				
				return aPlanta;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
		return null;
	}
	// ------------------------------------------------------------------------------
	//  Private Methods
	// ------------------------------------------------------------------------------

	private PlantaDto armaPlanta(ResultSet result) throws SQLException {
		String description = result.getString("DESCRIPTION");
		String commonName = result.getString("COMMONNAME");
		String cientificName = result.getString("SCIENTIFICNAME");
		String family = result.getString("FAMILY");
		int id = result.getInt("ID");
		return new PlantaDto(id, commonName, cientificName, family, description);
	}	
}