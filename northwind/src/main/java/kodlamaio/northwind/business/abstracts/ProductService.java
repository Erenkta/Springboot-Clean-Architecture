package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	
	apiDataResult<List<Product>> getAll();
	apiResult add(Product product);
	
	apiDataResult<Product> getByProductName(String productName);

	apiDataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

	apiDataResult<List<Product>>  getByProductNameOrCategoryId(String productName,int categoryId);

	apiDataResult<List<Product>>  getByCategoryIdIn(List<Integer> categories); 

	apiDataResult<List<Product>>  getByProductNameContains(String productName);

	apiDataResult<List<Product>>  getByProductNameStartsWith(String productName);

	apiDataResult<List<Product>>  getByNameAndCategory(String productName,int categoryId);
	
}
