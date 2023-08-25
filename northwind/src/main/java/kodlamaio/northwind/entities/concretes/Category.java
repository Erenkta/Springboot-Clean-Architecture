package kodlamaio.northwind.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor //Bunları eklememiz lazım
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"}) //Sürekli birbirini çağırmasın diye yani döngüyü engellemek için
public class Category {
	
	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	//İlişki oluşturmak için yazdık normalde tablomuzda yok
	@OneToMany(mappedBy="category") //mappedBy ve silinirse falan nolucak diye 2 parametre var 
	private List<Product> products;
	
	//Burda da sanırım dedik ki burada tuttuğumuz product category adlı yer ile OneToMany ilişkisine sahip
	
}
