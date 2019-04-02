package se.cygni.multiproto.client;

import org.springframework.web.client.RestTemplate;
import se.cygni.multiproto.entity.Car;

public class RESTClient {
	public static void main( String[] args ) {
		RestTemplate restTemplate = new RestTemplate();
		Car car = restTemplate.getForObject("http://localhost:8080/rest/car/tesla", Car.class);

		if (car == null) {
			throw new RuntimeException("Car is null");
		}

		System.out.println(car.toString());
	}
}
