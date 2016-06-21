package com.ncubo.contactos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ncubo.contactos.persistencia.Dao;

public class Contactos {
	public static void obtieneContactosDesdeArchivo(String file_path) throws IOException, SQLException
	{
		File archivo = new File(file_path);
		FileReader fileReader = new FileReader(archivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		

		String linea;
		while((linea = bufferedReader.readLine()) != null)
		{
			seperadaColumnas(linea);
		}
		
		bufferedReader.close();
		
	}
	private static void seperadaColumnas (String linea) throws SQLException
	{
		List <String[]> listaDatosPersona = new ArrayList<String[]>();
		listaDatosPersona.add(linea.split(","));
		Dao dao = new Dao();
		dao.insertarEnBaseDatos(listaDatosPersona.remove(0));
	}
}
