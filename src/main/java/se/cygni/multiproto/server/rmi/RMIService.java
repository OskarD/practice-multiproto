package se.cygni.multiproto.server.rmi;

import se.cygni.multiproto.entity.Car;
import se.cygni.multiproto.exception.UnknownCarException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIService extends Remote {

	Car getCar(String name) throws UnknownCarException, RemoteException;
}
