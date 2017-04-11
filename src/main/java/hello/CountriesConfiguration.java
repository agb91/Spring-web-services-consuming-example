package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountriesConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("countries.wsdl");
		return marshaller;
	}

	@Bean
	public CountriesClient quoteClient(Jaxb2Marshaller marshaller) {
		CountriesClient client = new CountriesClient();
		client.setDefaultUri("http://localhost:8080/ws/countries.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}