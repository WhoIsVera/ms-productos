package com.example.msproductos.exception;

public class BusinessException extends RuntimeException{
	String mensaje;
	public BusinessException() {
		super();
	}
	public BusinessException(String message) {
		this.mensaje = message;
	}
	@Override
	public String getMessage() {
		return this.mensaje;
	}
}
