package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;

public interface UserService {
	apiResult add(User user);
	apiDataResult<User> getByEmail(String email);
}
