package kodlamaio.northwind.core.utilities.results.withData;

import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;

public class apiDataResult<T> extends apiResult {

	private T data; //T'yi kullanma sebebimiz Data'nın türünü bilmediğimizden Generic olsun diye
	
	public apiDataResult(T data,boolean success, String message) { 
		super(success, message);
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public apiDataResult(T data,boolean success) { 
		super(success);
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}


}
