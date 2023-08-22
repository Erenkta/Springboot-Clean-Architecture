package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController //CRUD işlemlerini gerçekleştireceğimiz controller
@RequestMapping("/api/products") //Bu adrese gelen requestleri bu controller karşılayacak
public class ProductsController {
	
	
	private ProductService productService; // Dao -> business -> api şeklinde iletişim oluyor
	//Biz bağımlı olmamak için bu işlemi Service ile gerçekleştiricez 
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public List<Product> getAll(){
		return this.productService.getAll();
	}
}
