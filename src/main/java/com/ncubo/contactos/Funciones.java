package com.ncubo.contactos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Funciones {
	
	public void descargarArchivo(String urlArchivoADescargar, String direccionArchivoFinal) throws IOException
	{
		URL website = new URL(urlArchivoADescargar);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(direccionArchivoFinal);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
	}
	
	public void descomprimirArchivo(String direccionArchivoADescomprimir, String destinoArchivoADescomprimir) throws ZipException{
		ZipFile zipFile = new ZipFile(direccionArchivoADescomprimir);
		zipFile.extractAll(destinoArchivoADescomprimir);
	}
	
	public void borrarDirectorio(String direccionABorrar) throws IOException
	{
		FileUtils.forceDelete(new File(direccionABorrar));
	}
	
	public boolean existeDireccion(String direccionAVerificar)
	{
		File f = new File(direccionAVerificar);
		if( f.exists() )
		{ 
			return true;
		}
		return false;
	}
	
	public void crearDirectorio(String directorioACrear) throws IOException
	{
		Path path = Paths.get(directorioACrear);
		if ( !Files.exists(path) )
		{
			Files.createDirectories(path);
		}
	}

}
