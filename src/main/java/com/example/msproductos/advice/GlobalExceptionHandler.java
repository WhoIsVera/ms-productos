package com.example.msproductos.advice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.msproductos.errors.ApiErrors;
import com.example.msproductos.exception.BusinessException;
import com.example.msproductos.exception.IdNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>();
		  detalles.add("Verbo HTTP no soportado por el método");
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
		  return ResponseEntity.status(status).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>(); 
		  detalles.add("MediaType no soportado"); 
		  detalles.add(ex.getMessage()); 
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now()); 
		  return ResponseEntity.status(status).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>(); 
		  detalles.add("Parámetro de peticion no encontrado"); 
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now()); 
		  return ResponseEntity.status(status).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>(); 
		  detalles.add("Variable de URL no encontrada"); 
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now()); 
		  return ResponseEntity.status(status).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>(); 
		  detalles.add("Formatos no coinciden"); 
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now()); 
		  return ResponseEntity.status(status).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> detalles = new ArrayList<String>(); 
		  detalles.add("RequestBody is not readable"); 
		  ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now()); 
		  return ResponseEntity.status(status).body(errores);
	}
	@ExceptionHandler(IdNotFoundException.class) 
	 public ResponseEntity<Object> handleIdNotFoundException(RuntimeException ex) { 
	  ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()); 
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errores); 
	 } 
	  
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
	    List<String> detalles = new ArrayList<String>();
	    String mensaje = "";
	    ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errores);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		final List<String> errors = new ArrayList<String>(); 
		   
		   
		  for (final FieldError error : ex.getBindingResult().getFieldErrors()) { 
		   errors.add(error.getField() + ": " + error.getDefaultMessage()); 
		  } 
		  ApiErrors errores = new ApiErrors("Datos inválidos", errors, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now()); 
		  return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errores);
	}


}
