package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.entities.concretes.Product;

public interface CategoryService {
	Product getByProductName(String productName);

	Product getByProductNameAndCategoryId(String productName,int categoryId);

	List<Product> getByProductNameOrCategoryId(String productName,int categoryId);

	List<Product> getByCategoryIdIn(List<Integer> categories); 

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProdcutNameStartsWith(String productName);

	List<Product> getByNameAndCategory(String productName,int categoryId);
}
