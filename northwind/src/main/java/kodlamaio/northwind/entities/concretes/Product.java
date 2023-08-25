package kodlamaio.northwind.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor //Bunları eklememiz lazım
@NoArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	/*
	@Column(name="category_id")
	private int categoryId;
	*/ //altta join colum yaptık ve category ile product'ı birbirine id ile bağladık artık buna gerek yok
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name = "category_id") //Engin hoca farklı bir yöntem ile relation kurdu ve tablomuzda bir category_id kısmı olucak
	private Category category;
	
	//Burdaki yazım şu demek. Category tablosuyla ManyToOne ilişkisi var ve bu ilişki category_id dediğimiz field ile sağlanıyor demek
}
