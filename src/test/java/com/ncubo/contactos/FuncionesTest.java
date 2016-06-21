package com.ncubo.contactos;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import net.lingala.zip4j.exception.ZipException;

public class FuncionesTest {
	
	private String url = "http://www.tse.go.cr/zip/padron/alpoas.zip";
	private String[] urlVector = url.split("/");
	private String nombreArchivo = urlVector[urlVector.length-1];
	private String destinoArchivoADescomprimir = "test/";
	private String descomprimirFolderTest = "src/test/resources/";
	private String descomprimirArchivoTest = "PruebaDescomprimir.zip";
	private String descomprimidoArchivoTest = "PruebaDescomprimir.txt";
	
	@BeforeMethod
	public void crearCarpetas() throws IOException
	{
		Funciones funciones = new Funciones();
		funciones.crearDirectorio(destinoArchivoADescomprimir);
	}
	
	@Test
	public void descargarTest() throws IOException
	{
		String direccionArchivo = "test/"+nombreArchivo;
		Funciones funciones = new Funciones();
		
		funciones.descargarArchivo(url, direccionArchivo);
		Assert.assertEquals(funciones.existeDireccion(direccionArchivo), true);
	}
	
	@Test
	public void descomprimirTest() throws IOException, ZipException
	{
		String direccionFinalDescompresion = destinoArchivoADescomprimir + descomprimidoArchivoTest;
		Funciones funciones = new Funciones();
		funciones.descomprimirArchivo(descomprimirFolderTest + descomprimirArchivoTest, destinoArchivoADescomprimir);
		Assert.assertEquals(funciones.existeDireccion(direccionFinalDescompresion), true);
	}
	
	@AfterMethod
	public void borrarCarpetasCreadasParaTest() throws IOException
	{
		Funciones funciones = new Funciones();
		funciones.borrarDirectorio(destinoArchivoADescomprimir);
	}
}
