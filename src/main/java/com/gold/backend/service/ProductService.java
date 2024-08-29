package com.gold.backend.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gold.backend.model.Product;
import com.gold.backend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository Repository;
	
	public List<Product> listarProductos() {
        return Repository.findAll();
    }
	
	public Product guardarProducto(Product producto) {
        return Repository.save(producto);
    }
	
	public Product ObtenerProducto(Integer Id) {
		return Repository.findById(Id).get();
		
	}
	
	public void eliminarProducto(Integer id) {
        Repository.deleteById(id);
    }
	

}
