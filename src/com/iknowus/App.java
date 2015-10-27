package com.iknowus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public class App {	
	public static String name = "WS_Iknowus";
	public static String version = "0.0.1";

	private static final Logger Log = Logger.getLogger(App.class);
	private static String urlConfiguracion = "C://dualBiz//Iknowus//configuration.properties";

	/**
	 * Metodo que carga los datos del archivo de configuracion de la aplicacion.
	 * 
	 * @return Properties
	 */
	private static Properties Configuracion() {
		InputStream stream = null;
		Properties properties = new Properties();
		try {
			stream = new FileInputStream(urlConfiguracion);
			properties.load(stream);
		} catch (IOException e) {
			Log.error("No se pudo cargar el archivo property en direccion:" + urlConfiguracion, e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					Log.error(e.getMessage(), e);
				}
			}
		}
		return properties;
	}
	
	public static Long getCurrentTime(){
		return Calendar.getInstance(TimeZone.getTimeZone(App.TIME_ZONE)).getTimeInMillis();
	}

	private static final Properties properties = App.Configuracion();

	// PROPIEDADES DE LA BASE DE DATOS
	public static String DATABASE_SERVER = properties.getProperty("database.server");
	public static String DATABASE_PORT = properties.getProperty("database.port");
	public static String DATABASE_NAME = properties.getProperty("database.name");
	public static String DATABASE_USER = properties.getProperty("database.user");
	public static String DATABASE_PASSWORD = properties.getProperty("database.password");

	// PARA OBTENER LAS RUTAS DE LAS IMAGENES
	public static String path_images_read = properties.getProperty("imagen.servidor");
	public static String path_images_write = properties.getProperty("imagen.servidor.write");
	public static String TIME_ZONE="GMT-4";
	
	
	//CANTIDAD DE DIAS DE VIGENCIA DE UN ANUNCIO 
	public static String TIME_PUBLICATION = properties.getProperty("publication.duration");
	//TIPO DE CAMBIO DEL DOLAR
	public static String DOLLAR_CHANGETYPE = properties.getProperty("money.dollar");

}
