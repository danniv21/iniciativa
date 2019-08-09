package pe.com.claro.claroclub.departamento.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String code;
	private final HttpStatus status;
	
	public BaseException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

}
