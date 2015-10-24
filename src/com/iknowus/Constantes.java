package com.iknowus;

public class Constantes {

	/*
	 * VALUES
	 */
	public static class Values {		
		public static final Integer PENDING = 1;
		public static final Integer NOT_PENDING = 0;

		public static final Integer DISABLE = 0;
		public static final Integer ENABLE = 1;
		public static final Integer DELETE = 2;

		public static final Long COMPANY_DEFAULT = 1L;
		public static final Integer DEFAULT_ORDER = 0;
		public static final String DEFAULT_GSON = "{}";
		public static final String DEFAULT_CODE = "undefined";

		
		public static final int READ = 3;
		public static final int NOREAD = 4;
		public static final int PREVIEW_ENABLE = 5;
		public static final int PREVIEW_DISABLE = 6;
		// con relacion a las fechas
		public static final int ADS_VALID = 7;
		public static final int ADS_LAPSED = 8; // CADUCADO
		//marca de vendido,alquilado,permutado en la entidad
		public static final Integer MARK_ENTITY = 9;
	}

	/*
	 * TYPE_CLASIFICATION
	 */
	public static class Type_Classification {
		public static final Long TIPO_USUARIO = 1L;
		public static final Long TIPO_DASHBOARD = 2L;
		public static final Long TIPO_MOVIL = 3L;
		public static final Long TIPO_FILTRO = 4L;
		public static final Long MODALIDADE_COMERCIALIZACION = 5L;
		public static final Long TIPO_NOTIFICACION = 6L;
		public static final Long TIPO_MONEDA = 7L;
		public static final Long TIPO_SERVICIO = 8L;
		public static final Long TIPO_OPCIONAL = 9L;
		public static final Long TIPO_CATEGORIA_ENCUESTA = 10L;
		public static final Long TIPO_PREGUNTA = 11L;
		public static final Long TIPO_ENCUESTA = 12L;
		public static final Long TIPO_CAMBIO = 13L;
		public static final Long TIPO_CMS_INFO = 14L;
		public static final Long TIPO_CMS_PAGE = 15L;
		public static final Long TIPO_COMENTARIOS = 16L;
		public static final Long TIPO_PARAMETROS_PUBLICACIONES = 17L;
		public static final Long TIPO_PARAMETROS_ACTUALIZACION = 18L;
	}

	/*
	 * CATEGORIAS
	 */
	public static class Categories {
		public static final Long CASA = 1L;
		public static final Long TERRENOS = 2L;
		public static final Long DEPARTAMENTOS = 3L;
		public static final Long LOCAL_COMERCIAL = 4L;
		public static final Long OFICINA = 5L;
		public static final Long CASA_CAMPO = 6L;
	}

	/*
	 * CLASIFICADORES
	 */
	public static class User_Types {
		public static final Long USUARIO_MOVIL = 1L;
		public static final Long USUARIO_WEB = 2L;
	}

	public static class Movil_Types {
		public static final Long ANDROID = 3L;
		public static final Long IOS = 4L;
	}

	public static class Filter_Types {
		public static final Long RANGO = 5L;
		public static final Long SELECCION_SIMPLE = 6L;
		public static final Long SELECCION_MULTIPLE = 7L;
		public static final Long TEXTO = 8L;
	}

	public static class Modalidade_Types {
		public static final Long VENTA = 9L;
		public static final Long ALQUILER = 10L;
		public static final Long ANTICRETICO = 11L;
		public static final Long PREVENTA = 12L;
		public static final Long PERMUTA = 13L;

		// public static final List<Long> LST_CLASSIFIERS_MODALIDADE =
		// Collections.unmodifiableList(Arrays.asList(VENTA, ALQUILER, ANTICRETICO, PREVENTA, PERMUTA));
	}

	public static class Notification_Types {
		public static final Long MENSAJE_MASIVO = 14L;
		public static final Long MENSAJE_LUGAR = 15L;
		public static final Long MENSAJE_PERSONAL = 16L;
	}

	public static class Money_Types {
		public static final Long USD = 17L;
		public static final Long BS = 18L;
		public static final String Dolares = "$us ";
		public static final String Bolivianos = "Bs. ";
	}

	public static class Services_Types {
		public static final Long PORTADA = 19L;
		public static final Long ANUNCIO_LISTADO = 20L;
		public static final Long NOTIFICACIONES = 21L;
		public static final Long FOOT_ADS = 22L;
	}

	public static class Optional_Types {
		public static final Long CANTIDAD = 23L;
		public static final Long URL = 24L;
		public static final Long IMAGE = 25L;
		public static final Long VIDEO = 26L;
		public static final Long ENCUESTA = 27L;
	}
	
	public static class Publications_Parameters {
		public static final Long CANTIDAD_PUBLICACIONES_NORMAL = 48L;
		public static final Long CANTIDAD_PUBLICACIONES_INMOBILIARIA = 49L;
		public static final Long CANTIDAD_FOTOS_NORMAL = 50L;
		public static final Long CANTIDAD_FOTOS_INMOBILIARIA = 51L;
		public static final Long TIEMPO_DURACION_NORMAL = 52L;
		public static final Long TIEMPO_DURACION_INMOBILIARIA = 53L;
		public static final Long CANTIDAD_INTERVALO_ADS_LISTA = 56L;
	}
	
	public static class Update_Parameters {
		public static final Long UPDATE_DATE = 54L;
		public static final Long UPDATE_DESCRIPTION = 55L;		
		public static final Long LAST_VERSION_CODES = 57L;
	}
	
	public static class Change_Types {
		public static final Long DOLAR = 37L;		
	}
}
