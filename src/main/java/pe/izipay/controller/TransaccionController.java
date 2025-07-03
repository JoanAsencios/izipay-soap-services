package pe.izipay.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;
import pe.izipay.service.ServiceBusService;
import pe.izipay.service.TransaccionService;

@Endpoint
@RequiredArgsConstructor
public class TransaccionController {

  private static final String NAMESPACE_URI = "http://izipay.pe/ws/transaction/services";
  private final ServiceBusService serviceBusService;

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TransaccionRequest")
  @ResponsePayload
  public TransaccionResponse handleTransaction(@RequestPayload TransaccionRequest request) {
    return serviceBusService.procesarTransaccion(request);
  }


}
