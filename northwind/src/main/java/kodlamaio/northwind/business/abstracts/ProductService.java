package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	
	apiDataResult<List<Product>> getAll();
	apiResult add(Product product);
	
}
