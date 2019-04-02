package se.cygni.multiproto.server.rpc;

import com.googlecode.jsonrpc4j.JsonRpcService;
import se.cygni.multiproto.entity.Car;

@SuppressWarnings("unused")
@JsonRpcService("/rpc/carService")
public interface RPCService {

	Car getCar();
}
