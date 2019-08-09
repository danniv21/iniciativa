package pe.com.claro.claroclub.category.dto;

import java.io.Serializable;
import java.util.List;

public class ListCategoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private AuditResponse auditResponse;
	private List<CategoryResponse> listCategoryResponse;

	public List<CategoryResponse> getListCategoryResponse() {
		return listCategoryResponse;
	}

	public void setListCategoryResponse(List<CategoryResponse> listCategoryResponse) {
		this.listCategoryResponse = listCategoryResponse;
	}

	public AuditResponse getAuditResponse() {
		return auditResponse;
	}

	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}
	
	@Override
	public String toString() {
		return "ListCategoryResponse [auditResponse=" + auditResponse
				+ ", listCategoryResponse=" + listCategoryResponse + "]";
	}
	
}
