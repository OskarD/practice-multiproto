package se.cygni.multiproto.server.grpc.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import se.cygni.multiproto.CarServiceGrpc;
import se.cygni.multiproto.CarServiceOuterClass;

import java.util.List;

@GRpcService
public class GRPCService extends CarServiceGrpc.CarServiceImplBase {
	@Override
	public void getCar(CarServiceOuterClass.CarRequest request, StreamObserver<CarServiceOuterClass.CarResponse> responseObserver) {
		// CarRequest has toString auto-generated.
		System.out.println(request);

		// You must use a builder to construct a new Protobuffer object
		CarServiceOuterClass.CarResponse response = CarServiceOuterClass.CarResponse.newBuilder()
				.setName("Tesla")
				.addAllDrivers(List.of("Oskar", "Erik"))
				.build();

		// Use responseObserver to send a single response back
		responseObserver.onNext(response);

		// When you are done, you must call onCompleted.
		responseObserver.onCompleted();
	}
}
