package com.ncubo.contactos;

import java.io.IOException;
import java.sql.SQLException;

import net.lingala.zip4j.exception.ZipException;

public class Main {

	private static String url = "http://www.tse.go.cr/zip/padron/padron_completo.zip";
	private static String[] urlVector = url.split("/");
	private static String nombreArchivo = urlVector[urlVector.length-1];
	private static String destinoArchivoADescomprimir = "download/";
	
	public static void main(String[] args) throws IOException, ZipException, SQLException {
		Funciones funciones = new Funciones();
		funciones.descargarArchivo(url, nombreArchivo);
		funciones.crearDirectorio(destinoArchivoADescomprimir);
		funciones.descomprimirArchivo(nombreArchivo,destinoArchivoADescomprimir);
		Contactos.obtieneContactosDesdeArchivo(destinoArchivoADescomprimir + "PADRON_COMPLETO.txt");
	}

}
