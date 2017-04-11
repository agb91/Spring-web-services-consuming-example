
package hello;

import countries.wsdl.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(CountriesClient countriesClient) {
		return args -> {
			String id = "SPA";

			GetCountryResponse response = countriesClient.getCountry(id);
			System.err.println(response.getCountry().getCapital());
		};
	}

}
