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
@CrossOrigin(origins = "https://frontend-despliuegue-fk7.vercel.app/")
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
	 
	 @PostMapping("/Products")
	 public void GuardarProducto(@RequestBody Product product) {
		 Servicio.guardarProducto(product);
	 	}
	 
	 @DeleteMapping("/ProductE/{id}") 
	 public void EliminarProducto(@PathVariable Integer id) {
		 Servicio.eliminarProducto(id);
		 
	 }
	 
	 }
	 

    

