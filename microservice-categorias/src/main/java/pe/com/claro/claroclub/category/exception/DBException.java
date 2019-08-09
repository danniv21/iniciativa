package pe.com.claro.claroclub.category.exception;

import org.springframework.http.HttpStatus;

public class DBException extends BaseException {

	private static final long serialVersionUID = 1L;

	public DBException(String code, String message, HttpStatus status) {
		super(code, message, status);
	}

}