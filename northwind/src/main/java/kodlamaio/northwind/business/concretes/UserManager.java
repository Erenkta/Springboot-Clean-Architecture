package kodlamaio.northwind.business.concretes;


import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.withData.apiDataResult;
import kodlamaio.northwind.core.utilities.results.withData.apiDataSuccessResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiResult;
import kodlamaio.northwind.core.utilities.results.withoutData.apiSuccessResult;

public class UserManager implements UserService  {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public apiResult add(User user) {
		this.userDao.save(user);
		return new apiSuccessResult("Kullanıcı eklendi (" + new Timestamp(System.currentTimeMillis()) + ")");
	}

	@Override
	public apiDataResult<User> getByEmail(String email) {
		return new apiDataSuccessResult<User>(this.userDao.getByEmail(email), "Kullanıcı başarıyla getirildi") ;
	}

}
