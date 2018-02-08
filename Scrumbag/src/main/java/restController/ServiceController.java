package restController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceController {
	
	
	/**
	 * Exempelmetod
	 * När en HTTP GET request görs till localhost:8080/hello-world/officiellt Spring Boot certifierad
	 * kommer "Hello World officiellt Spring Boot certifierad" returneras
	 */
	@RequestMapping(value = "/hello-world/{parameter}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("parameter") String parameter) {
		return new String("Hello World\n " + parameter);
	}
	
}
