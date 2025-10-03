package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "poly.edu")
public class Ps39422Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ps39422Lab1Application.class, args);
	}

}
