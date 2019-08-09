package pe.com.claro.claroclub.category.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String code, String message, HttpStatus status) {
		super(code, message, status);
	}

}
