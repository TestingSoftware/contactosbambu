package com.ncubo.contactos.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Dao 
{
	static Conexion conexion = new Conexion();
	private final String INSERT_QUERY = "INSERT INTO datos_persona (nombre, apellidos, "
			+ "email, telefono, id_empresa, id_persona, creado_por, modificado_por, fecha_creacion,"
			+ "fecha_modificacion, registro_borrado,fecha_borrado, "
			+ "usuario_skype, celular, direccion_entrega, latitud, longitud)"
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? , ?, ?, ?)";
	
	public void insertarEnBaseDatos(String [] persona) throws SQLException
	{
		PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(INSERT_QUERY);

		preparedStatement.setString(1, persona[5]);
		preparedStatement.setString(2, persona[6] + persona[7]);
		preparedStatement.setString(3, "");
		preparedStatement.setString(4, "");
		preparedStatement.setInt(5, 0);
		preparedStatement.setInt(6, 0);
		preparedStatement.setString(7, "");
		preparedStatement.setString(8, "");
		preparedStatement.setString(9, "0000-00-00");
		preparedStatement.setString(10, "0000-00-00");
		preparedStatement.setInt(11, 0);
		preparedStatement.setString(12, "0000-00-00");
		preparedStatement.setString(13, "");
		preparedStatement.setString(14, "");
		preparedStatement.setString(15, "");
		preparedStatement.setDouble(16, 0.0);
		preparedStatement.setDouble(17, 0.0);
		preparedStatement.executeUpdate();
	}
}
