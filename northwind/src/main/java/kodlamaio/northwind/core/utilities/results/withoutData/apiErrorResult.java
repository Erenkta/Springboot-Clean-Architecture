package kodlamaio.northwind.core.utilities.results.withoutData;

public class apiErrorResult extends apiResult{

	public apiErrorResult() {
		super(false);
		// TODO Auto-generated constructor stub
	}
	
	public apiErrorResult(String message) {
		super(false, message);
		// TODO Auto-generated constructor stub
	}

}
