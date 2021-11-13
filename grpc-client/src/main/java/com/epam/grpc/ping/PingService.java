package com.epam.grpc.ping;

//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
import lombok.extern.log4j.Log4j2;
//import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PingService extends Event{
    

//    @GrpcClient("grpc-server")
//    private PingServiceGrpc.PingServiceBlockingStub serviceStub;
//
//    public String receiveRequest(String str) {
//        PingRequest request = PingRequest.newBuilder()
//                .setMessage(str)
//                .build();
//
//        this.serviceStub.getMessage(request);
//        String res = serviceStub.getMessage(request).getMessage();
//
//
//        log.info("Received response " + res);
//
//        return res;
//    }

}

