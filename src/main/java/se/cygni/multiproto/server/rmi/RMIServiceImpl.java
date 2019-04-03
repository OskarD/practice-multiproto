package se.cygni.multiproto.server.rmi;

import org.springframework.stereotype.Service;
import se.cygni.multiproto.entity.Car;
import se.cygni.multiproto.exception.UnknownCarException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

@Service
public class RMIServiceImpl implements RMIService {
	@Override
	public Car getCar(String name) throws UnknownCarException {
		if (!name.equals("Tesla")) {
			throw new UnknownCarException();
		}

		return new Car("Tesla", List.of("Oskar", "Erik"));
	}

	public void createStubAndBind() throws RemoteException {
		Registry registry = LocateRegistry.createRegistry(1099);
		RMIService stub = (RMIService) UnicastRemoteObject.exportObject(this, 0);
		registry.rebind("CarService", stub);
	}
}
