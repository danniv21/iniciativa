package pe.com.claro.claroclub.departamento.service;

import java.util.Map;

import org.springframework.http.HttpHeaders;

public interface IDepartamentoService {

	Map<String, Object> getAllDepartments(HttpHeaders httpHeaders);
	
}
