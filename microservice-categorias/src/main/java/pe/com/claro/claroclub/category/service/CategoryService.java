package pe.com.claro.claroclub.category.service;


import org.springframework.http.HttpHeaders;

import pe.com.claro.claroclub.category.dto.ListCategoryResponse;

public interface CategoryService {

	public ListCategoryResponse getAllCategory(HttpHeaders httpHeaders);
	
}
