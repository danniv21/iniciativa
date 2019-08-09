package pe.com.claro.claroclub.category.dto;

import java.io.Serializable;

public class CategoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descripcion;
	private int prioridad;
	private String urlImagen;
	private String colorString;
	private String urlImagenSeleccionada;

	public CategoryResponse() {
	}
	
	public CategoryResponse(Long id, String descripcion, int prioridad, String urlImagen, String colorString, String urlImagenSeleccionada) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.urlImagen = urlImagen;
		this.colorString = colorString;
		this.urlImagenSeleccionada = urlImagenSeleccionada;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getColorString() {
		return colorString;
	}
	public void setColor(String colorString) {
		this.colorString = colorString;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setNombre(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public String getUrlImagenSeleccionada() {
		return urlImagenSeleccionada;
	}
	public void setUrlImagenSeleccionada(String urlImagenSeleccionada) {
		this.urlImagenSeleccionada = urlImagenSeleccionada;
	}
	
}
