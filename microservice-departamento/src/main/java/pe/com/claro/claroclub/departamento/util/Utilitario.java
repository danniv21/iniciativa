package pe.com.claro.claroclub.departamento.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import pe.com.claro.claroclub.departamento.config.ApplicationProperties;
import pe.com.claro.claroclub.departamento.dto.AuditResponse;
import pe.com.claro.claroclub.departamento.exception.BaseException;

public class Utilitario implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Utilitario.class);
	
	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSXXX", Locale.getDefault());
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}
	
	public static String parseDateFormat(String dateformat) {
		DateFormat sdf = new SimpleDateFormat(dateformat);
		sdf.setTimeZone(TimeZone.getTimeZone(Constantes.TIME_ZONE_LIMA));
		return sdf.format(new Date());
	}
	
	public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		return new ObjectMapper().setDateFormat(getLocalFormat())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
				.writeValueAsString(o);
	}
	
	public static boolean validarVacioObjecto(Object objeto) {
		return objeto == Constantes.OBJECT_EMPTY;
	}
	
	public static void validarIdTransaccion(HttpHeaders httpHeaders, ApplicationProperties applicationProperties) throws BaseException{
		boolean flagParamObligatorio;
		flagParamObligatorio = ObjectUtils.isEmpty(httpHeaders) || httpHeaders.size()== 0;
		
		if(flagParamObligatorio && ObjectUtils.isEmpty(httpHeaders.get(Constantes.HEADER_ID_TRANSACCION)) || httpHeaders.get(Constantes.HEADER_ID_TRANSACCION).get(0).isEmpty()){
			httpHeaders.set(Constantes.HEADER_ID_TRANSACCION,UUID.randomUUID().toString().substring(0,18));
			flagParamObligatorio=true;
		}
		if (flagParamObligatorio){
			throw new BaseException(applicationProperties.departmentCodigoIdf1 , applicationProperties.departmentMensajeCodigoIdf1,HttpStatus.BAD_REQUEST);
		}
	}
	
	public static boolean toCalendar(final String iso8601string) {
		Calendar calendar = GregorianCalendar.getInstance();
		boolean hayError = true;
		try {

			String s = iso8601string.replace("Z", "+00:00");
			if (iso8601string.length() == Constantes.VEINTE) { // *** Sin Precision de Milisegundos
				s = s.substring(0, 22) + s.substring(23);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				hayError = false;
			}
			if (iso8601string.length() == Constantes.VEINTICUATRO) { // *** Con Precision de Milisegundos
				s = s.substring(0, 26) + s.substring(27);
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(s);
				calendar.setTime(date);
				hayError = false;
			}
		} catch (IndexOutOfBoundsException e) {
			logger.error("Ocurrio un error al recorrer la cadena de Fecha", e);

		} catch (Exception e) {
			logger.error("Ocurrio un error al convertir a Date la cadena de la fecha", e);

		}
		return hayError;
	}
	
	public static AuditResponse registroAuditoriaResponse(Exception e, ApplicationProperties properties, HttpHeaders httpHeaders, String metodo){
		
		AuditResponse auditResponse=new AuditResponse();
		auditResponse.setFecha(Utilitario.parseDateFormat(Constantes.FORMAT_DATE_TIME_ZONE));
		
		if(e.getClass().getName().contains("BaseException")){
			
			BaseException baseException=(BaseException)e;
			auditResponse.setCodigoRespuesta(baseException.getCode());
			auditResponse.setDescripcionRespuesta(baseException.getMessage());
			auditResponse.setStatus(baseException.getStatus()); 
			auditResponse.setMetodo(metodo);
		}else{
			
			auditResponse.setCodigoRespuesta(properties.departmentCodigoIdf3);
			auditResponse.setDescripcionRespuesta(properties.departmentMensajeCodigoIdf3.replace("$error", e.toString()));
			auditResponse.setStatus(HttpStatus.OK); 
			auditResponse.setMetodo(metodo);
		}
		
		auditResponse.setIdTransaccion(httpHeaders.get(Constantes.HEADER_ID_TRANSACCION).get(0));
		
		return auditResponse;
	}
	
}
