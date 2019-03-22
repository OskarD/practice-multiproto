package se.cygni.multiproto.server.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.cygni.multiproto.entity.Car;

@RestController("/json")
public class RESTController {

	@RequestMapping()
	public Car getCar() {
		return new Car();
	}
}
