package com.example.msproductos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.msproductos.entity.Productos;

@Repository
//ES PARA LLEVAR/TRAER INFO HACIA Y DESDE LA BDD
//Por eso se parametriza con el nombre y el tipo de la pk
public interface ProductosRepository extends JpaRepository<Productos, Integer>{
	
//Aqui implementamos un patron de diseño, que es DAO. Lo que se hace es crear un componente
	//que se encargara de encapsular todas las operaciones de acceso a datos(CONSULTAS)
	
	//Esto se hace atraves de heredar esa logica de a interface JPARepository, que ya tiene todo listo, solo para que nosotros hagamos el consumo
	//En esta interface le pasamos 2 argumentos, la clase PRODUCTOS(que es el modelo con el cual e dara forma a todos los resultados) y
	//el tipo de dato que tiene PK de la llave primaria de la entidad, es decir INTEGER

	@Query("SELECT p FROM Productos p WHERE p.nombre=:nombre")//JPQL java persisten 
	Optional<Productos> findByName(@Param("nombre")String nombre);
}
