package pe.com.claro.claroclub.departamento.dto;

import java.io.Serializable;

public class DepartamentoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	
	public DepartamentoResponse() {

	}
	
	public DepartamentoResponse(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
