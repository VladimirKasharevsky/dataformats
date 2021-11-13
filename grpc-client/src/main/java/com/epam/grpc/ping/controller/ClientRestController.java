package com.epam.grpc.ping.controller;


import com.epam.grpc.ping.PingRequest;
import com.epam.grpc.ping.PingService;
import com.epam.grpc.ping.PingServiceGrpc;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ClientRestController {

    @Autowired
    private PingServiceGrpc.PingServiceBlockingStub stub;


    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Ping") final String str) {
        PingRequest request = PingRequest.newBuilder()
                .setMessage(str)
                .build();
        stub.getMessage(request);
        log.info("Received " + str);
        return str;
    }
}
