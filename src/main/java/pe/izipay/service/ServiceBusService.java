package pe.izipay.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceBusService {

  private final TransaccionService transaccionService;
  private final AuditoriaService auditoriaService;

  /**
   * Orquesta la transacción pasando por validación, auditoría y ejecución del servicio.
   */
  public TransaccionResponse procesarTransaccion(TransaccionRequest request) {
    log.info("Iniciando procesamiento de transacción desde Service Bus");

    // Validacion
    validarRequest(request);

    // Auditoría previa
    auditoriaService.registrarEvento("Recepción de transaccion", request.toString());

    // Orquestación al servicio de negocio real
    TransaccionResponse response = transaccionService.procesarTransaccion(request);

    // Auditoría posterior
    auditoriaService.registrarEvento("Respuesta de transaccion", response.toString());

    log.info("Transaccion procesada exitosamente desde Service Bus");
    return response;
  }

  private void validarRequest(TransaccionRequest request) {
    if (request.getTransactionId() == null || request.getTransactionId().isEmpty()) {
      throw new IllegalArgumentException("El transactionId es obligatorio");
    }
    if (request.getAmount() <= 0) {
      throw new IllegalArgumentException("El monto debe ser mayor a 0");
    }
  }
}
