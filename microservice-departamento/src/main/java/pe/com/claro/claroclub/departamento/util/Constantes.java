package pe.com.claro.claroclub.departamento.util;

import org.springframework.http.MediaType;

public final class Constantes {

	private Constantes() {
	}

	// HTTP Constants
	public static final String HTTP_MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON_UTF8_VALUE;
	// HTTP HEADERS
	public static final String HEADER_TIMESTAMP = "timestamp";
	public static final String HEADER_ID_TRANSACCION = "idTransaccion";

	// RESPONSE ERROR
	public static final String RESPONSE_EXCEPTION_TIMEOUT = "TIMEOUT";
	public static final String RESPONSE_EXCEPTION_TIMEOUT2 = "TIME OUT";

	// VACIOS
	public static final Object OBJECT_EMPTY = null;
	public static final String STRING_EMPTY = "";

	// EXPRESSION FORMATS
	public static final String FORMAT_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String TIME_ZONE_LIMA = "America/Lima";
	
	//FOR CALENDAR
	public static final int VEINTE = 20;
	public static final int VEINTICUATRO = 24;
	
	// LOG INFO
	public static final String LOG_INICIO_METODO= "[INICIO de metodo: {}]";
	public static final String LOG_INICIO_VALIDACION= "[INICIO] - Validar parametros obligatorios";
	public static final String LOG_FIN_VALIDACION= "[FIN]- Validar parametros obligatorios";
	public static final String LOG_FIN_METODO="[FIN de metodo: {}]";
	public static final String LOG_TIEMPOS_PROCESO="[{}]- Tiempo total de proceso(ms):{}";
	public static final String LOG_RESPONSE_CONTROLADOR="[{}]- Response del proceso:{}";
	public static final String LOG_FIN_CONTROLADOR="[FIN de Controller Metodo: {}]";
	public static final String LOG_REQUEST_HEADER="[{}]- Request Header: {}";
	public static final String LOG_REQUEST_BODY="[{}]- Request Body: {}";
	public static final String LOG_RESPONSE_BODY="[{}]- Response Body: {}";
	public static final String LOG_DATOS_HEADER="[{}]- Datos de Header: {}";
	public static final String LOG_DATOS_BODY="[{}]- Datos de Body: {}";
	public static final String LOG_DATOS_STATUS="[{}]- Datos de Status: {}";
}
