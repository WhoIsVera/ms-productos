package com.example.msproductos.request;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



//REQUEST MODELO PARA CAPTURAR DATOS que viene desde el cliente hacia el prodcuto
//el cliente puede ser postman
@NotBlank(message="El nombre no puede estar vacio ni contener solo espacios en blanco")
@Size(min=5, max=20, message="El nombre no debe de ser menor a 5 o mayor a 20 caracteres")
@Future(message="La fecha debe de ser mayor a la actual")
@DecimalMax(value="999.99", message="Este es el valor maximo que debe de tener")

public class ProductoRequest {
	
	//Esta clase e intefaces constituyen la CAPA DE PERSISTENCIA del proyecto, aqui hay un concepto importante que es
	//La serializacion
	
	//DAD: DATA ACCESS OBJECT es el que se encagar de encapsular las consultas
int productoid;
	int deptoid;
	String nombre;//no este vacio y no se pase de varacteres, no sea nulo, que no se repita validacion
	LocalDate fechaCad;  //no seaantigua
	int precioCompra;	//que sea mnor a 999.99
	int precioVenta;	//igual sea menor a 999.99
	String refrigerado; // Y o N
	// defino la estructura igual ala entidad, pero sin anotaciones que son los @Column que la convierten en una entidad, es un modelo con a misma forma pero diferente proposito
	public ProductoRequest(int productoid, int deptoid, String nombre, LocalDate fechaCad, int precioCompra,
			int precioVenta, String refrigerado) {
		super();
		this.productoid = productoid;
		this.deptoid = deptoid;
		this.nombre = nombre;
		this.fechaCad = fechaCad;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.refrigerado = refrigerado;
	}
	public int getProductoid() {
		return productoid;
	}
	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}
	public int getDeptoid() {
		return deptoid;
	}
	public void setDeptoid(int deptoid) {
		this.deptoid = deptoid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(LocalDate fechaCad) {
		this.fechaCad = fechaCad;
	}
	public int getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(String refrigerado) {
		this.refrigerado = refrigerado;
	}
	@Override
	public String toString() {
		return "ProductoRequest [productoid=" + productoid + ", deptoid=" + deptoid + ", nombre=" + nombre
				+ ", fechaCad=" + fechaCad + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta
				+ ", refrigerado=" + refrigerado + "]";
	}
	
	
}
