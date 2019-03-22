package se.cygni.multiproto.entity;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Car {

	public String name;

	public List<String> drivers;

	public Car() {
		this.name = "Tesla";
		this.drivers = List.of("Oskar", "Erik");
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", drivers=" + drivers +
				'}';
	}
}
