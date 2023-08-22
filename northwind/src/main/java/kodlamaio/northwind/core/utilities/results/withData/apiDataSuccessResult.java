package kodlamaio.northwind.core.utilities.results.withData;

public class apiDataSuccessResult<T> extends apiDataResult<T>{

	
	public apiDataSuccessResult(T data) { //Data aldık işlemler sonucu geri döndük mesela update olabilir
		super(data, true);
		// TODO Auto-generated constructor stub
	}
	
	public apiDataSuccessResult(String message) { // Data aldık işlemini yaptık  mesajı verdik ama geri dönmedik mesela create olabilir
		super(null, true, message);
		// TODO Auto-generated constructor stub
	}

	
	public apiDataSuccessResult(T data, String message) { //Data aldık işlemler sonucu geri döndük ve mesajını da verdik mesela update yine
		super(data, true, message);
		// TODO Auto-generated constructor stub
	}
	
	public apiDataSuccessResult() { // Data aldık işlemini yaptık mesaj dönmek de istemedik 
		super(null, true);
	}
	

}
