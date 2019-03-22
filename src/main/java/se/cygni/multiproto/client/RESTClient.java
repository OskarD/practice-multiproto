package se.cygni.multiproto.client;

import org.springframework.web.client.RestTemplate;
import se.cygni.multiproto.entity.Car;

public class RESTClient {
	public static void main( String[] args ) {
		final String uri = "http://localhost:8080/rest/car/tesla";

		RestTemplate restTemplate = new RestTemplate();
		Car car = restTemplate.getForObject(uri, Car.class);

		if (car == null) {
			throw new RuntimeException("Car is null");
		}

		System.out.println(car.toString());
	}
}
