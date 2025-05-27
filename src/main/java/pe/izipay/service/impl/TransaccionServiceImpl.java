package pe.izipay.service.impl;

import org.springframework.stereotype.Service;
import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;
import pe.izipay.model.entity.Transaccion;
import pe.izipay.service.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService {

  @Override
  public TransaccionResponse procesarTransaccion(TransaccionRequest trx) {
    //Agregar validacion de saldo de tarjeta
    return TransaccionResponse.builder()
        .transactionId(trx.getTransactionId())
        .transactionCode(trx.getTransactionCode())
        .build();
  }

  public Transaccion procesarCompra() {
    return null;
  }

  public Transaccion procesarAnulacion() {
    return null;
  }

  public Transaccion procesarReversa() {
    return null;

  }
}
