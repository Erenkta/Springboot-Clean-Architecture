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
	private String getSuccessMessage = "Data başarılı şekilde getirildi";
	
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


	@Override
	public apiDataResult<Product> getByProductName(String productName) {
		return new apiDataSuccessResult<Product>
		(this.productDao.getByProductName(productName),getSuccessMessage);
	}


	@Override
	public apiDataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		return new apiDataSuccessResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),getSuccessMessage);
	}


	@Override
	public apiDataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new apiDataSuccessResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),getSuccessMessage);
	}


	@Override
	public apiDataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new apiDataSuccessResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),getSuccessMessage);
	}


	@Override
	public apiDataResult<List<Product>> getByProductNameContains(String productName) {
		return new apiDataSuccessResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),getSuccessMessage);
	}


	@Override
	public apiDataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new apiDataSuccessResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),getSuccessMessage);
	}


	@Override
	public apiDataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new apiDataSuccessResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryId),getSuccessMessage);
	}



}
