package br.com.cea.diogo.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8925318150690311795L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}

	public ResourceNotFoundException(String exception, Throwable cause) {
		super(exception);
	}

}
