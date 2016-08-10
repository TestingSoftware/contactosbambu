package com.ncubo.contactos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Conexion instancia = null;
	private Connection conexion;
	
	public Conexion()
	{
        crearConexion(); 
	}
	
	public static Conexion getInstancia()
	{
		if (instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public Connection getConexion()
    {
		    return conexion;
    }
	
	private void crearConexion() 
	{
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/contactos", "root", "123456");  
        }
        catch (SQLException | ClassNotFoundException exception)
        {
            System.err.println(exception.getMessage());
        }
	}
	
}
