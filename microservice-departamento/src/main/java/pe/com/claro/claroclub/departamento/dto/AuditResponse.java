package pe.com.claro.claroclub.departamento.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuditResponse {
	
	
	private String metodo;
	private String idTransaccion;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private String fecha;
	
	@JsonIgnore
	private HttpStatus status;
	
	
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	/**
	 * Obtener variable status
	 * @return status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * Setear variable status
	 * @param status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AuditResponse [metodo=" + metodo + 
				", idTransaccion=" + idTransaccion + 
				", codigoRespuesta=" + codigoRespuesta + 
				", descripcionRespuesta=" + descripcionRespuesta + 
				", fecha=" + fecha + "]";
	}


	
}
