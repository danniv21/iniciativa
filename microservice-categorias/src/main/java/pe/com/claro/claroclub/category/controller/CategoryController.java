package pe.com.claro.claroclub.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import pe.com.claro.claroclub.category.dto.ListCategoryResponse;
import pe.com.claro.claroclub.category.service.CategoryService;


@RestController
@RequestMapping("/categoria")
@Validated
public class CategoryController {
	
	@Autowired
	private CategoryService listCategoryService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public ResponseEntity<ListCategoryResponse> listCategory(@RequestHeader HttpHeaders httpHeaders) throws JsonProcessingException {
		
		ListCategoryResponse listCategoryResponse = listCategoryService.getAllCategory(httpHeaders);
		return new ResponseEntity<>(listCategoryResponse,  listCategoryResponse.getAuditResponse().getStatus());
		
	}
	
}
