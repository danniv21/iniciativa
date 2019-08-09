package pe.com.claro.claroclub.category.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
	
	@Value("${category.codigo.idf0}")
	public String categoryCodigoIdf0;
	
	@Value("${category.mensaje.idf0}")
	public String categoryMensajeCodigoIdf0;
	
	@Value("${category.codigo.idf1}")
	public String categoryCodigoIdf1;
	
	@Value("${category.mensaje.idf1}")
	public String categoryMensajeCodigoIdf1;
	
	@Value("${category.codigo.idf2}")
	public String categoryCodigoIdf2;
	
	@Value("${category.mensaje.idf2}")
	public String categoryMensajeCodigoIdf2;
	
	@Value("${category.codigo.idf3}")
	public String categoryCodigoIdf3;
	
	@Value("${category.mensaje.idf3}")
	public String categoryMensajeCodigoIdf3;
}
