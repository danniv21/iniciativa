package pe.com.claro.claroclub.departamento.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
	
	@Value("${department.codigo.idf0}")
	public String departmentCodigoIdf0;
	
	@Value("${department.mensaje.idf0}")
	public String departmentMensajeCodigoIdf0;
	
	@Value("${department.codigo.idf1}")
	public String departmentCodigoIdf1;
	
	@Value("${department.mensaje.idf1}")
	public String departmentMensajeCodigoIdf1;
	
	@Value("${department.codigo.idf2}")
	public String departmentCodigoIdf2;
	
	@Value("${department.mensaje.idf2}")
	public String departmentMensajeCodigoIdf2;
	
	@Value("${department.codigo.idf3}")
	public String departmentCodigoIdf3;
	
	@Value("${department.mensaje.idf3}")
	public String departmentMensajeCodigoIdf3;
	
	@Value("${department.codigo.idt1}")
	public String departmentCodigoIdt1;
	
	@Value("${department.mensaje.idt1}")
	public String departmentMensajeCodigoIdt1;
	
	@Value("${department.codigo.idt2}")
	public String departmentCodigoIdt2;
	
	@Value("${department.mensaje.idt2}")
	public String departmentMensajeCodigoIdt2;
}
