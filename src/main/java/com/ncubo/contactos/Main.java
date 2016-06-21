package com.ncubo.contactos;

import java.io.IOException;

import net.lingala.zip4j.exception.ZipException;

public class Main {

	private static String url = "http://www.tse.go.cr/zip/padron/alpoas.zip";
	private static String[] urlVector = url.split("/");
	private static String nombreArchivo = urlVector[urlVector.length-1];
	private static String destinoArchivoADescomprimir = "prueba/";
	
	public static void main(String[] args) throws IOException, ZipException {
		Funciones funciones = new Funciones();
		funciones.descargarArchivo(url, nombreArchivo);
		funciones.descomprimirArchivo(nombreArchivo,destinoArchivoADescomprimir);
		funciones.borrarDirectorio(nombreArchivo);
		funciones.borrarDirectorio(destinoArchivoADescomprimir);
	}

}
