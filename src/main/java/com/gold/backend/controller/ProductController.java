package com.gold.backend.controller;

import java.util.List;

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

import com.gold.backend.model.Product;
import com.gold.backend.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ver/Produc")
public class ProductController {
	
	private final ProductService Servicio;

    ProductController(ProductService Servicio) {
        this.Servicio = Servicio;
    }
	
	 @GetMapping("/Productos")
	    public ResponseEntity<List<Product>> listarProductos() {
	        return ResponseEntity.ok(Servicio.listarProductos());
	    }
	 
	 
	 @GetMapping("/Productt/{id}")
	 public ResponseEntity<Product> ObtenerProducto(@PathVariable Integer id) {
		try {
			Product Product = Servicio.ObtenerProducto(id);
			return new  ResponseEntity<Product>(Product,HttpStatus.OK);
		}catch(Exception excepcion) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		
		}
	 
	 @PostMapping("/Products")
	 public void GuardarProducto(@RequestBody Product product) {
		 Servicio.guardarProducto(product);
	 	}
	 
	 @PutMapping("/Productz/{id}") 
	 public ResponseEntity<?>ActualizarProducto(@RequestBody Product product, @PathVariable Integer id){
		try {
			Product ProductoExistente = Servicio.ObtenerProducto(id);
			ProductoExistente.setNAME_PRODUCT(product.getNAME_PRODUCT());
			ProductoExistente.setDESCRIPTION_PRODUCT(product.getDESCRIPTION_PRODUCT());
			ProductoExistente.setAMOUNT_PRODUCT(product.getAMOUNT_PRODUCT());
			ProductoExistente.setPRICE_PRODUCT(product.getPRICE_PRODUCT());
			
			Servicio.guardarProducto(ProductoExistente);
			
			Servicio.guardarProducto(product);
			return new  ResponseEntity<Product>(HttpStatus.OK);
		}catch(Exception excepcion) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			 
		}
			 
	 }
	 
	 @DeleteMapping("/ProductE/{id}") 
	 public void EliminarProducto(@PathVariable Integer id) {
		 Servicio.eliminarProducto(id);
		 
	 }
	 
	 }
	 

    

