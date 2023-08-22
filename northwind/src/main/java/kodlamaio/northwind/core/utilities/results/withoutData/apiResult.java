package kodlamaio.northwind.core.utilities.results.withoutData;

public class apiResult { //Super type olarak bilinir bir interface görevi görüyor aslında ama tek başına da bir anlamı var o yüzden interface yapmadık
	private boolean success;
	private String message;
	
	public apiResult(boolean success) {
		this.success = success;
	}
	public apiResult(boolean success,String message) {
		//this.success = success;
		this(success); // tek parametreli ve success isteyen constructor'unu çağırdık
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	public String getMessage() {
		return this.message;
	}
	
}
