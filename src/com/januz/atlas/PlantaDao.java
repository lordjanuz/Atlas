package com.januz.atlas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantaDao {
	Session session = new Session();

	public void createPlanta(PlantaDto aPlanta) throws Exception {
		try {
			PreparedStatement st = session
					.connection()
					.prepareStatement(
							"insert into PLANTA (COMMONNAME, CIENTIFICNAME, FAMILY, DESCRIPTION) values (?,?,?,?)");
			st.setString(1, aPlanta.getCommonName());
			st.setString(2, aPlanta.getCientificName());
			st.setString(3, aPlanta.getFamily());
			st.setString(4, aPlanta.getDescription());
			st.execute();
		} catch (SQLException ex) {
			System.err.println("La Planta Ya Existe..."+ex.getMessage());
		}

	}

	public void listPlanta() {
		ResultSet result = null;
		try {
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA");
			result = st.executeQuery();
			while (result.next()) {
				System.out.print("ID: ");
				System.out.println(result.getInt("id"));

				System.out.print("Nombre comun: ");
				System.out.println(result.getString("COMMONNAME"));

				System.out.print("Nombre Cientifico: ");
				System.out.println(result.getString("CIENTIFICNAME"));

				System.out.print("Familia: ");
				System.out.println(result.getString("CIENTIFICNAME"));

				System.out.print("Descripcion: ");
				System.out.println(result.getString("CIENTIFICNAME"));

				System.out.println("=======================");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
	}

	public void getPlantaByCientificName(PlantaDto aPlanta) {
		ResultSet result = null;
		try {
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA where CIENTIFICNAME = ?");
			st.setString(1, aPlanta.getCientificName());
			result = st.executeQuery();
			while (result.next()) {
				System.out.print("ID: ");
				System.out.println(result.getInt("id"));

				System.out.print("Nombre comun: ");
				System.out.println(result.getString("COMMONNAME"));

				System.out.print("Nombre Cientifico: ");
				System.out.println(result.getString("CIENTIFICNAME"));

				System.out.print("Familia: ");
				System.out.println(result.getString("FAMILY"));

				System.out.print("Descripcion: ");
				System.out.println(result.getString("DESCRIPTION"));

				System.out.println("=======================");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
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
		PlantaDto aPlanta;
		try {
			
			PreparedStatement st = session.connection().prepareStatement(
					"select * from PLANTA where ID = ?");
			st.setString(1, anId);
			result = st.executeQuery();
			while (result.next()) {
				
				String description = result.getString("DESCRIPTION");
				String commonName = result.getString("COMMONNAME");
				String cientificName = result.getString("CIENTIFICNAME");
				String family = result.getString("FAMILY");
				
				System.out.print("ID: ");
				System.out.println(result.getInt("id"));

				System.out.print("Nombre comun: ");
				System.out.println(commonName);

				System.out.print("Nombre Cientifico: ");
				System.out.println(cientificName);

				System.out.print("Familia: ");
				System.out.println(family);

				System.out.print("Descripcion: ");
				System.out.println(description);
				System.out.println("=======================");
				
				aPlanta = new PlantaDto(commonName, cientificName, family, description);
				return aPlanta;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage() + "Error");
		}
		return null;
	}

}

// EJEMPLO DE
// SQLITE######################################################################################
// public void saveAlumno(Alumno alumno){
// try {
// PreparedStatement st =
// connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
// st.setString(1, alumno.getNombre());
// st.setString(2, alumno.getApellidos());
// st.execute();
// } catch (SQLException ex) {
// System.err.println(ex.getMessage());
// }
//
// }
// ##########################################################################################################

// public Person findByIssuerAndIdentifier(String issuerIdentifier, String
// personIdentifier) {
// return
// executeSimpleQuery("SELECT p FROM Person p JOIN p.relations r WHERE r.parent.identifier = ?1 AND p.identifier = ?2",
// issuerIdentifier, personIdentifier);
// }
//
// public Person findByIssuerPersonIdentifierAndRelationshipCode(String
// issuerIdentifier, String personIdentifier, String relationshipCode) {
// return
// executeSimpleQuery("SELECT p FROM Person p JOIN p.relations r where r.parent.identifier = ?1 and p.identifier = ?2  and r.type.code = ?3",
// issuerIdentifier, personIdentifier,
// relationshipCode);
// }
//
// public List<Person> findByIssuer(String issuerIdentifier) {
// return
// executeQuery("SELECT p FROM Person p JOIN p.relations r WHERE r.parent.identifier = ?1",
// issuerIdentifier);
// }
//
// public Person findByIdentifier(String anIdentifier) {
// return executeSimpleQuery("SELECT p FROM Person p WHERE p.identifier = ?1",
// anIdentifier);
// }
//
// //-----------------------------------------------------------------------------
// //Constructors
// //-----------------------------------------------------------------------------
//
// public PersonDao(EntityManager anEntityManager) {
// super(anEntityManager, Person.class);
// }
//
// public PersonDao() {
// super(Person.class);
// }
// }