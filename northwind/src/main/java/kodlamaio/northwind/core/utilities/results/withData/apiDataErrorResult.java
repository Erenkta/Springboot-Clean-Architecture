package kodlamaio.northwind.core.utilities.results.withData;

public class apiDataErrorResult<T> extends apiDataResult<T> {

	public apiDataErrorResult(T data) {
		super(data, false);
		// TODO Auto-generated constructor stub
	}
	
	public apiDataErrorResult(T data, String message) {
		super(data, false, message);
		// TODO Auto-generated constructor stub
	}
	
	public apiDataErrorResult(String message) {
		super(null, false, message);
	}
	
	public apiDataErrorResult() {
		super(null, false);
	}


}
