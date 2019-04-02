package se.cygni.multiproto.client;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import se.cygni.multiproto.entity.Car;

import java.net.URL;
import java.util.Map;

public class RPCClient {
	public static void main( String[] args ) throws Throwable {
		JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:8080/rpc/carService"), Map.of("Content-Type", "application/json"));
		Car car = client.invoke("getCar", null, Car.class);

		if (car == null) {
			throw new RuntimeException("Car is null");
		}

		System.out.println(car.toString());
	}
}
