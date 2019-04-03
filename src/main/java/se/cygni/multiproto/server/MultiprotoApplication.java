package se.cygni.multiproto.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.cygni.multiproto.server.rmi.RMIServiceImpl;

import java.rmi.RemoteException;

@SpringBootApplication
public class MultiprotoApplication {

	public static void main(String[] args) throws RemoteException {
		SpringApplication.run(MultiprotoApplication.class, args);

		RMIServiceImpl rmiService = new RMIServiceImpl();
		rmiService.createStubAndBind();
	}
}
