package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;


public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	Product getByProductNameAndCategoryId(String productName,int categoryId);
	List<Product> getByProductNameOrCategoryId(String productName,int categoryId);
	
	//yeni öğrendiklerin
	List<Product> getByCategoryIdIn(List<Integer> categories); 
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	
	
	/*Böyle yazabilir miyiz dene bunu
	@Query("SELECT * FROM products")
	List<Product> getAll();*/
	
	//JpQuel nedir ? --> Sorguyu objeler üzerinden yazmayı sağlar. Istersen sql sorgusu da yazabilirsin //Bunu yazarkan Tablo unutulur işlemler Entity üstünden yapılır
	@Query("From Product where productName=:productName and categoryId=:categoryId") //Product -> Entity olan - productName=:productName field = parametre demek -
	List<Product> getByNameAndCategory(String productName,int categoryId);
}
