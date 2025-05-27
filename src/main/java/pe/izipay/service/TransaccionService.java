package pe.izipay.service;

import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;

public interface TransaccionService {

  TransaccionResponse procesarTransaccion(TransaccionRequest trx);

}
