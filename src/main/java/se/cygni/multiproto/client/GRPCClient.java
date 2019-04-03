package se.cygni.multiproto.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import se.cygni.multiproto.CarServiceGrpc;
import se.cygni.multiproto.CarServiceOuterClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GRPCClient {
	public static void main( String[] args ) throws InterruptedException {
		System.out.println(" -------------- Normal request");
		makeCarRequest();
		System.out.println(" -------------- Stream request");
		makeCarsRequest();
	}

	private static void makeCarRequest() {
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

	private static void makeCarsRequest() throws InterruptedException {
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6565")
				.usePlaintext()
				.build();

		// Replace the previous synchronous code with asynchronous code.
		// This time use an async stub:
		CarServiceGrpc.CarServiceStub stub = CarServiceGrpc.newStub(channel);

		// Construct a request
		CarServiceOuterClass.CarsRequest request =
				CarServiceOuterClass.CarsRequest.newBuilder().build();

		final CountDownLatch finishLatch = new CountDownLatch(1);

		// Make an Asynchronous call. Listen to responses w/ StreamObserver
		StreamObserver<CarServiceOuterClass.CarResponse> streamObserver = new StreamObserver<>() {
			public void onNext(CarServiceOuterClass.CarResponse response) {
				System.out.println(response);
			}

			public void onError(Throwable t) {
				System.out.println("Error: " + t.getLocalizedMessage());
				finishLatch.countDown();
			}

			public void onCompleted() {
				// Typically you'll shutdown the channel somewhere else.
				// But for the purpose of the lab, we are only making a single
				// request. We'll shutdown as soon as this request is done.
				System.out.println("Shutting down");
				channel.shutdownNow();
				finishLatch.countDown();
			}
		};
		stub.getCars(request, streamObserver);

		finishLatch.await(1, TimeUnit.MINUTES);
	}
}
