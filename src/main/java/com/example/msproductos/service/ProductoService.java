package com.example.msproductos.service;

import java.util.List;

import com.example.msproductos.entity.Productos;
import com.example.msproductos.request.ProductoRequest;

public interface ProductoService {
//esta es una interfaces de negocio 
	//aqui se enlistan todas las operaciones de la que este microservicio se estara haciendo cargo
	//se expresan en metodos abstractos
	
	Productos guardar(ProductoRequest request);
	Productos actualizar(ProductoRequest request);
	Productos buscar(int id);
	String eliminar(int id);
	List mostrar();
}
