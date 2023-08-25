package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	  apiDataResult<List<Product>> getAll();
	  //Pagination işlemleri için method yazacağız
	  apiDataResult<List<Product>> getAllByPage(int pageNo,int pageSize);
	  apiDataResult<List<Product>> getAllSorted();

      apiResult add(Product product);
     
      apiDataResult<Product> getByProductName(String productName);
	  
      apiDataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	  
      apiDataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	  
      apiDataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	  
      apiDataResult<List<Product>> getByProductNameContains(String productName);
	  
      apiDataResult<List<Product>> getByProductNameStartsWith(String productName);

      apiDataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
      
      apiDataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
      
      
      
      
    
      
}
