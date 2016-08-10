package com.ncubo.contactos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ncubo.contactos.persistencia.Dao;

public class Contactos {
	
	static Dao dao = new Dao();
	static List<String[]> arrayRegistro = new ArrayList<String[]>();
	static int index = 0;
	
	public static void obtieneContactosDesdeArchivo(String filePath) throws IOException, SQLException
	{
		File archivo = new File(filePath);
		FileReader fileReader = new FileReader(archivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String linea;
		while((linea = bufferedReader.readLine()) != null)
		{
			obtieneRegistroPadron(linea);
		}
		bufferedReader.close();	
	}
	
	private static void obtieneRegistroPadron (String linea) throws SQLException
	{
		List <String[]> listaDatosPersona = new ArrayList<String[]>();
		listaDatosPersona.add(linea.split(","));
		
		construyeListaRegistro(listaDatosPersona.remove(0));
	}
	
	private static void construyeListaRegistro(String [] registro)
	{
		Logger log = Logger.getLogger(Contactos.class);
		if(index <= 999)
		{	
			System.out.println("Llenando Array");
			log.debug("Llenando Array");
			arrayRegistro.add(registro);
		}
		else
		{
			log.debug("Realizando inserción");
			arrayRegistro = dao.insertar(arrayRegistro);
			index = 0;
		}
		
		index += 1;
	}
}
