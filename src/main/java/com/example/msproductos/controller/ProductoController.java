package com.example.msproductos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import com.example.msproductos.entity.Productos;
import com.example.msproductos.logic.ProductoLogic;
import com.example.msproductos.request.ProductoRequest;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("productos/")
public class ProductoController {
	@Autowired
	ProductoLogic service;
	//http://localhost:8095/productos/
	@GetMapping
	public ResponseEntity<List<Productos>> mostrar(){
		List<Productos> productos = service.mostrar();		
		return new ResponseEntity<List<Productos>>(productos,HttpStatus.OK);
	}
	
///http://localhost:8095/productos/ aqui NOpones el id para poder INRESAR UN sus datos
	@PostMapping
	public ResponseEntity<Productos> guardar(@Valid @RequestBody ProductoRequest request){
		Productos prod = service.guardar(request);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	///http://localhost:8095/productos/ aqui si pones el id para poder actualizar sus datos
	@PutMapping
	public ResponseEntity<Productos> actualizar(@RequestBody ProductoRequest request){
		Productos prod = service.actualizar(request);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	//http://localhost:8095/productos/buscar/22
	@GetMapping("buscar/{id}")
	public ResponseEntity<Productos> buscar(@PathVariable int id){
		Productos prod = service.buscar(id);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	//http://localhost:8095/productos/eliminar/22
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String mensaje = service.eliminar(id);
		return new ResponseEntity<String>(mensaje,HttpStatus.OK);
	}
	
	@RequestMapping("/error")
    public String handleError() {
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
	
	
	

}
