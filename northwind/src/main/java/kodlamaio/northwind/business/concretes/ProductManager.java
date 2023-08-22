package kodlamaio.northwind.business.concretes;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withData.apiDataSuccessResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiSuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public apiDataResult<List<Product>> getAll() {
		return new apiDataSuccessResult<List<Product>>(this.productDao.findAll(),
				"Datalar veritabanından başarılı bir şekilde çekildi ("+new Timestamp(System.currentTimeMillis())+")");
			//TimeStamp kendim yaptım
	}


	@Override
	public apiResult add(@RequestBody Product product) {
		this.productDao.save(product);
		return new apiSuccessResult("Ürün veritabanına başarılı bir şekilde eklendi");
	}

}
