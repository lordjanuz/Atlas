package com.januz.atlas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Session {

	// --------------------------------------------------------------------------
	// -- Attributes
	// --------------------------------------------------------------------------

	// URL PARA CODA
	String url = "/home/januz/workspace/Atlas/Atlas.db";
	// URL PARA CASA
	//String url = "D:\\Atlas.db";
	
	// URL PARA CODA
	//String url = "F:\\Atlas.db";
	Connection connect;

	public Connection connection(){
		return this.connect;
	}
	
	public Session() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n"
					+ ex.getMessage());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			Logger.getLogger("Error al cerrar la Conexion: " + ex);
		}
	}
}
