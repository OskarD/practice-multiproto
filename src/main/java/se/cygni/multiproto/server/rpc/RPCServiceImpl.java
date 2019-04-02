package se.cygni.multiproto.server.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;
import se.cygni.multiproto.entity.Car;

import java.util.List;

@AutoJsonRpcServiceImpl
@Service
public class RPCServiceImpl implements RPCService {

	@Override
	public Car getCar() {
		return new Car("Tesla", List.of("Oskar", "Erik"));
	}
}
