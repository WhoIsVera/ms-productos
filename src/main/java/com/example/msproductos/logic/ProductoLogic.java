package com.example.msproductos.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msproductos.entity.Productos;
import com.example.msproductos.exception.BusinessException;
import com.example.msproductos.exception.IdNotFoundException;
import com.example.msproductos.repository.ProductosRepository;
import com.example.msproductos.request.ProductoRequest;
import com.example.msproductos.service.ProductoService;

@Service
//esta clase resuelve la logica de negocios con la ayuda del DAO(repository
//traemos o encontramos las interfaces por mediode la implementacion o (IMPLEMENTS)
public class ProductoLogic implements ProductoService {
	//ESTA CLASE ES LA QUE TIENE EL CONTROL DE CUANDO LLAMAR AL COMPONENTE INYECTADO, en este caso productosRepository, este es una capa diferente o un componente desacoplado
	
	//inyeccion de dependencias
	//mandamos a llamar a la otra interfaces pero con la inyeccion de dependencias
	//esta inyeccion de dependencias va acompañada de otro concepto. LA INVERSION DE CONTROL
	@Autowired
	
	//este autowired es de la inyeccion de dependecias de spring boot el modo mas facil usando la anotacion de arriba
	ProductosRepository repo;

	@Override
	public Productos guardar(ProductoRequest request) {
		//
		
		
		Productos prod = null;
		if(repo.findByName(request.getNombre()).isPresent()){
			System.out.println("Este producto ya existe");
			throw new BusinessException("Este producto ya existe");
		}else if(!(request.getRefrigerado().equals("Y") || request.getRefrigerado().equals("N"))) {
			
			System.out.println("El atributo refrigerador debe ser Y o N solamente");
			throw new BusinessException("El atributo refrigerador debe ser Y o N solamente");
		}
		else {
		// TODO Auto-generated method stub
		//la instaciacion del objecto con el que se trabaja es prod, el constructor esta vacio y por primera vez se le van dando sus atributos mediante los setter
		
		prod = new Productos();
		prod.setDeptoid(request.getDeptoid());
		prod.setNombre(request.getNombre());
		prod.setFechaCad(request.getFechaCad());
		prod.setPrecioCompra(request.getPrecioCompra());
		prod.setPrecioVenta(request.getPrecioVenta());
		prod.setRefrigerado(request.getRefrigerado());
		
		repo.save(prod);
		
		}
		return null;
	}

	@Override
	public Productos actualizar(ProductoRequest request) {
		// TODO Auto-generated method stub
		//aqui la instaciacion se trabaja con id existente, que se llena con info de la bdd obtenida atraves del metodo findById, ese lo busca en bs y nos devuelve un objeto
		//si si esta lo traemos con el metodo get()
		Productos prod = repo.findById(request.getProductoid()).get();
		//el get nos sirve para extraer el obejto si es que viene dentro del opcional, y si no podriamos hacer otra cosa en lugar de que directamente nos muestre un error NULLPOINTEREXCEPTION
		prod.setDeptoid(request.getDeptoid());
		prod.setNombre(request.getNombre());
		prod.setFechaCad(request.getFechaCad());
		prod.setPrecioCompra(request.getPrecioCompra());
		prod.setPrecioVenta(request.getPrecioVenta());
		prod.setRefrigerado(request.getRefrigerado());
		//metodo  salvar
		repo.save(prod);
		return null;
	}

	@Override
	public Productos buscar(int id) {
		// TODO Auto-generated method stub
		//metodo buscar por medio del id
		
		Productos prod= null;
		if(repo.findById(id).isPresent()) {
			prod = repo.findById(id).get();
		}
	else {
		throw new IdNotFoundException("No existe un producto con ese id");
	}
	return prod;
	}
	
	
	@Override
	public String eliminar(int id) {
		// TODO Auto-generated method stub
		//metodo eliminar por medio del id
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {
		//metodo mostrar todo
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
}
