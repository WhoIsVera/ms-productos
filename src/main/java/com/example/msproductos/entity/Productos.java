package com.example.msproductos.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="PRODUCTOS")
public class Productos implements Serializable{
//Entity es la clase que representa a la tabla dentro del aplicativo java
	//La serializacion es la desintegracion en bytes del estado de un objeto, para poder transmitirlo en la red
	//ejemplo cuando llevas unas hojas al triturador de basura
	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="PRODUCTO_ID", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productoid;
	
	@Column (name="DEPTO_ID", columnDefinition="NUMBER")
	int deptoid;
	
	@Column (name="NOMBRE", columnDefinition="NVARCHAR2(20)")
	String nombre;
	
	@Column (name="FECHA_CAD", columnDefinition="DATE")
	LocalDate fechaCad; 
	
	@Column (name="PRECIO_COMPRA", columnDefinition="NUMBER")
	int precioCompra;
	
	@Column (name="PRECIO_VENTA", columnDefinition="NUMBER")
	int precioVenta;
	
	@Column (name="REFRIGERADO", columnDefinition="CHAR")
	String refrigerado;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
