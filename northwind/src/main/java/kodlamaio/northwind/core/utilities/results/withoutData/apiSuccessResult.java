package kodlamaio.northwind.core.utilities.results.withoutData;

public class apiSuccessResult extends apiResult{

	public apiSuccessResult() {
		super(true);
	}
	
	public apiSuccessResult(String message) {
		super(true,message);
	}

}
