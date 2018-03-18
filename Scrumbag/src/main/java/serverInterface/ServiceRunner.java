package serverInterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceRunner {
	
	/**
	 * Startar server på port 8080
	 */
	  public static void main(String[] args) {
	        SpringApplication.run(ServiceRunner.class, args);
	    }

}
