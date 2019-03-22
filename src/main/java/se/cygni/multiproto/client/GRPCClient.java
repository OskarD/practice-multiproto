package se.cygni.multiproto.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import se.cygni.multiproto.CarServiceGrpc;
import se.cygni.multiproto.CarServiceOuterClass;

public class GRPCClient {
	public static void main( String[] args ) {
		// Channel is the abstraction to connect to a service endpoint
		// Let's use plaintext communication because we don't have certs
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6565")
				.usePlaintext()
				.build();

		// It is up to the client to determine whether to block the call
		// Here we create a blocking stub, but an async stub,
		// or an async stub with Future are always possible.
		CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);
		CarServiceOuterClass.CarRequest request =
				CarServiceOuterClass.CarRequest.newBuilder()
						.build();

		// Finally, make the call using the stub
		CarServiceOuterClass.CarResponse response =
				stub.getCar(request);

		System.out.println(response);

		// A Channel should be shutdown before stopping the process.
		channel.shutdownNow();
	}
}
