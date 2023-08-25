package kodlamaio.northwind.entities.concretes;

import java.util.List;

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


@Entity
@Data
@AllArgsConstructor //Bunları eklememiz lazım
@NoArgsConstructor
@Table(name="categories")
public class Category {
	
	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	//İlişki oluşturmak için yazdık normalde tablomuzda yok
	@OneToMany(mappedBy="categories") //mappedBy ve silinirse falan nolucak diye 2 parametre var //Engin hoca burda table ismi yazdı fakat değişken ismi yazılması gerekmez miydi araştır !!
	private List<Product> products;
	
	//Burda da sanırım dedik ki burada tuttuğumuz product categories adlı tablo ile OneToMany ilişkisine sahip
	
}
