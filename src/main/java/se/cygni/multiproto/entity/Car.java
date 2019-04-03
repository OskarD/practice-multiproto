package se.cygni.multiproto.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Car implements Serializable {

	public String name;

	public List<String> drivers;

	public Car() {
	}

	public Car(String name, List<String> drivers) {
		this.name = name;
		this.drivers = drivers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<String> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", drivers=" + drivers +
				'}';
	}
}
