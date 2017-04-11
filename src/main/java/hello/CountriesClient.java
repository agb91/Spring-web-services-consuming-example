
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import countries.wsdl.GetCountryRequest;
import countries.wsdl.GetCountryResponse;

public class CountriesClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountriesClient.class);

	public GetCountryResponse getCountry(String id) {

		GetCountryRequest request = new GetCountryRequest();
		request.setId(id);


		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,
						new SoapActionCallback("http://localhost:8080/ws"));

		return response;
	}

}
