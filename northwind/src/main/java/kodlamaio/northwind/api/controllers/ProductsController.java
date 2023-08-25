package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.entities.concretes.Product;

@RestController //CRUD işlemlerini gerçekleştireceğimiz controller
@RequestMapping("/api/products/") //Bu adrese gelen requestleri bu controller karşılayacak
public class ProductsController {
	
	
	private ProductService productService; // Dao -> business -> api şeklinde iletişim oluyor
	//Biz bağımlı olmamak için bu işlemi Service ile gerçekleştiricez 
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("getall")
	public apiDataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	@PostMapping("add")
	public apiResult add(Product product) {
		return this.productService.add(product);
	}
	@GetMapping("getByProductName")
	public apiDataResult<Product> getByProductName(@RequestParam String productName){ //Yapılan Requesteki parametrelere bak ve productName'i al
		return this.productService.getByProductName(productName);
	}
	
	
	/* 	3 tane bilgi vermeliyiz
	 * 	data (sadece bu zorunlu değil)
	 *  işlem sonucu (başarılı-başarısız)
	 *  mesaj 
	 * */
}
