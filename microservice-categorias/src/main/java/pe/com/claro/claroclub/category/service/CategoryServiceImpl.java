package pe.com.claro.claroclub.category.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.slf4j.MDCContextMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.com.claro.claroclub.category.config.ApplicationProperties;
import pe.com.claro.claroclub.category.dto.AuditResponse;
import pe.com.claro.claroclub.category.dto.CategoryResponse;
import pe.com.claro.claroclub.category.dto.ListCategoryResponse;
import pe.com.claro.claroclub.category.entity.Category;
import pe.com.claro.claroclub.category.repository.CategoryRepository;
import pe.com.claro.claroclub.category.util.Constantes;
import pe.com.claro.claroclub.category.util.Utilitario;

@Service("ListCategoryService")
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ApplicationProperties properties;

	public ListCategoryResponse getAllCategory(HttpHeaders httpHeaders) {

		String metodo = "listCategory";
		ListCategoryResponse listCategoryResponse = new ListCategoryResponse();

		logger.info(Constantes.LOG_INICIO_METODO, metodo);
		AuditResponse auditResponse = new AuditResponse();
		Gson gson = new Gson();

		try {
			logger.info(Constantes.LOG_INICIO_VALIDACION);
			Utilitario.validarIdTransaccion(httpHeaders, properties);
			logger.info(Constantes.LOG_FIN_VALIDACION);

			String idTransaccion = httpHeaders.get(Constantes.HEADER_ID_TRANSACCION).get(0);
			logger.info(idTransaccion);

			MDCContextMap mdcContextMap = new MDCContextMap();
			mdcContextMap.put("idTransaccion", idTransaccion);
			logger.info(Constantes.LOG_REQUEST_HEADER, metodo, gson.toJson(httpHeaders));
			List<Category> listCategory = categoryRepository.findByEnable(1);

			listCategoryResponse.setListCategoryResponse(summaryCategory(listCategory));

			// #AuditResponse
			if (listCategoryResponse.getListCategoryResponse().isEmpty()) {
				auditResponse.setCodigoRespuesta(properties.categoryCodigoIdf2);
				auditResponse.setDescripcionRespuesta(properties.categoryMensajeCodigoIdf2);
			} else {
				auditResponse.setCodigoRespuesta(properties.categoryCodigoIdf0);
				auditResponse.setDescripcionRespuesta(properties.categoryMensajeCodigoIdf0);
			}
			auditResponse.setStatus(HttpStatus.OK);
			auditResponse.setFecha(Utilitario.parseDateFormat(Constantes.FORMAT_DATE_TIME_ZONE));
			auditResponse.setIdTransaccion(idTransaccion);
			auditResponse.setMetodo(metodo);

			listCategoryResponse.setAuditResponse(auditResponse);
		} catch (Exception e) {
			System.out.println(e);
			listCategoryResponse
					.setAuditResponse(Utilitario.registroAuditoriaResponse(e, properties, httpHeaders, metodo));
		}
		finally {
			logger.info(Constantes.LOG_FIN_METODO, metodo);
			logger.info(Constantes.LOG_DATOS_BODY, metodo, new Gson().toJson(listCategoryResponse));
		}

		return listCategoryResponse;
	}

	public List<CategoryResponse> summaryCategory(List<Category> listCategory) {
		List<CategoryResponse> listSummaryCategory = new ArrayList<>();

		for (Category cat : listCategory) {
			CategoryResponse catResp = new CategoryResponse();
			catResp.setId(cat.getId());
			catResp.setNombre(cat.getName());
			catResp.setPrioridad(cat.getOrder_cat());
			catResp.setUrlImagen(cat.getUrl_image());
			catResp.setUrlImagenSeleccionada(cat.getUrl_image_selected());
			catResp.setColor(cat.getColor_image());
			listSummaryCategory.add(catResp);
		}

		return listSummaryCategory;
	}
}
