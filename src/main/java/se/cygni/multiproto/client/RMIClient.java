package se.cygni.multiproto.client;

import se.cygni.multiproto.entity.Car;
import se.cygni.multiproto.exception.UnknownCarException;
import se.cygni.multiproto.server.rmi.RMIService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
	public static void main(String[] args) throws RemoteException, UnknownCarException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry();
		RMIService server = (RMIService) registry
				.lookup("CarService");
		Car car = server.getCar("Tesla");
		System.out.println(car);
	}
}
