package pe.com.claro.claroclub.departamento.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import pe.com.claro.claroclub.departamento.dto.AuditResponse;
import pe.com.claro.claroclub.departamento.service.IDepartamentoService;

@RestController
@RequestMapping("/departamento")
@Validated
public class DepartamentoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);
	
	@Autowired
	private IDepartamentoService iDepartamentoService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, Object>> listDepartamento(@RequestHeader HttpHeaders httpHeaders) throws JsonProcessingException {
		
		long tiempoInicio = System.currentTimeMillis();
		
		Map<String, Object> listDepartamentoResponse = iDepartamentoService.getAllDepartments(httpHeaders);
		AuditResponse auditResponse = (AuditResponse) listDepartamentoResponse.get("auditResponse");
		Long fin = System.currentTimeMillis() - tiempoInicio;
		logger.info("Tiempo total de proceso(ms):{} ", fin);
		
		return new ResponseEntity<>(listDepartamentoResponse,  auditResponse.getStatus());
		
	}
	
}
