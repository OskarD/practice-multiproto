package se.cygni.multiproto.server.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.cygni.multiproto.entity.Car;

import java.util.List;

@RestController()
public class RESTController {

	@GetMapping("rest/car/tesla")
	public Car getCar() {
		return new Car("Tesla", List.of("Oskar", "Erik"));
	}
}
