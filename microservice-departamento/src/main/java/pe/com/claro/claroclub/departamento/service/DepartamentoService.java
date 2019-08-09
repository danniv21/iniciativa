package pe.com.claro.claroclub.departamento.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.slf4j.MDCContextMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.com.claro.claroclub.departamento.config.ApplicationProperties;
import pe.com.claro.claroclub.departamento.dto.AuditResponse;
import pe.com.claro.claroclub.departamento.dto.DepartamentoResponse;
import pe.com.claro.claroclub.departamento.entity.Department;
import pe.com.claro.claroclub.departamento.repository.CuponDepartamentoRepository;
import pe.com.claro.claroclub.departamento.util.Constantes;
import pe.com.claro.claroclub.departamento.util.Utilitario;

@Service("DepartamentoService")
public class DepartamentoService implements IDepartamentoService {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartamentoService.class);
	
	@Autowired
	private CuponDepartamentoRepository departamentoRepository;
	
	@Autowired
    private ApplicationProperties properties;
	
	@Override
	public Map<String, Object> getAllDepartments(HttpHeaders httpHeaders) {
		String metodo="listarDepartamentos";
		Map<String, Object> listDepartamentoResponse = new HashMap<>();
		logger.info(Constantes.LOG_INICIO_METODO, metodo);
		AuditResponse auditResponse=new AuditResponse();
		Gson gson = new Gson();
		
		try {
			logger.info(Constantes.LOG_INICIO_VALIDACION);
			Utilitario.validarIdTransaccion(httpHeaders, properties);
			logger.info(Constantes.LOG_FIN_VALIDACION);
			
			String idTransaccion =httpHeaders.get(Constantes.HEADER_ID_TRANSACCION).get(0);
			System.out.println(idTransaccion);
			
			MDCContextMap mdcContextMap = new MDCContextMap();
			mdcContextMap.put("idTransaccion", idTransaccion);
			logger.info(Constantes.LOG_REQUEST_HEADER, metodo, gson.toJson(httpHeaders));
			List<Department> listDepartment = departamentoRepository.findAllDepartments();
			//#AuditResponse
			if(listDepartment.isEmpty()) {
				auditResponse.setCodigoRespuesta(properties.departmentCodigoIdf2);
				auditResponse.setDescripcionRespuesta(properties.departmentMensajeCodigoIdf2);
			}
			else {
				auditResponse.setCodigoRespuesta(properties.departmentCodigoIdf0);
				auditResponse.setDescripcionRespuesta(properties.departmentMensajeCodigoIdf0);
			}
			listDepartamentoResponse.put("listDepartamentos", summaryDepartment(listDepartment));
			
			auditResponse.setStatus(HttpStatus.OK);
			auditResponse.setCodigoRespuesta(properties.departmentCodigoIdf0);
			auditResponse.setDescripcionRespuesta(properties.departmentMensajeCodigoIdf0);
			auditResponse.setFecha(Utilitario.parseDateFormat(Constantes.FORMAT_DATE_TIME_ZONE));
			auditResponse.setIdTransaccion(idTransaccion);
			auditResponse.setMetodo(metodo);
			
			listDepartamentoResponse.put("auditResponse", auditResponse);
		
		}
		catch(Exception e){
			System.out.println(e);
			listDepartamentoResponse.put("auditResponse", Utilitario.registroAuditoriaResponse(e,properties,httpHeaders, metodo));
		}
		finally {
			logger.info(Constantes.LOG_FIN_METODO, metodo);
			logger.info(Constantes.LOG_DATOS_BODY, metodo, new Gson().toJson(listDepartamentoResponse));
		}
		return listDepartamentoResponse;
	}
	
	public List<DepartamentoResponse> summaryDepartment(List<Department> listDepartment){
		List<DepartamentoResponse> listSummaryDepartment = new ArrayList<>();
		
		for(Department dpt: listDepartment) {
			DepartamentoResponse depResp = new DepartamentoResponse();
			depResp.setId(dpt.getId());
			depResp.setNombre(dpt.getName());
			listSummaryDepartment.add(depResp);
		}
		
		return listSummaryDepartment;
	}
	
}