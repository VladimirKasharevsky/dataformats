package com.epam.grpc.ping;

import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Log4j2
public class PingService extends PingServiceGrpc.PingServiceImplBase{

    @Override
    public void getMessage (PingRequest request, StreamObserver<PingResponse> responseStreamObserver){

        log.info("recivied message: {}", request.getMessage());

        PingResponse.Builder responseBuilder =
                PingResponse.newBuilder().setMessage("Pong");

        PingResponse pingResponse = responseBuilder.build();

        responseStreamObserver.onNext(pingResponse);
        responseStreamObserver.onCompleted();

    }

}
