package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.withData.apiDataErrorResult;

@RestController()
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) { // ? işareti ne döneceği tam belli olmayan yani belirli duruma bağlı olanlar // Valid yazmayı unutma yoksa validasyondan geçmez
		return ResponseEntity.ok(this.userService.add(user));
		
	}
	// 200 - 300 - 400 - 500 -> HttpResponse
	//AOP -> bütün methodlarımızı çevreleyen bir global exception handler olarak da bilinir
	
	@ExceptionHandler(MethodArgumentNotValidException.class) //tüm validation hatalarında bura çalışsın demek
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public apiDataErrorResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ // Object yazdık çünkü içerik sürekli değişebilir
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) { //Her bir field hatası için
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()); //Field'ı ve message'ını ekle //Message nasıl eklenir?
		}
		apiDataErrorResult<Object> errors = new apiDataErrorResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
	
}
