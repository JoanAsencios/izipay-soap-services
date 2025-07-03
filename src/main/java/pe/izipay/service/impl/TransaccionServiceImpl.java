package pe.izipay.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;
import pe.izipay.model.entity.Terminal;
import pe.izipay.model.entity.Transaccion;
import pe.izipay.repository.TerminalRepository;
import pe.izipay.repository.TransaccionRepository;

import java.util.UUID;
import pe.izipay.service.TransaccionService;

@Service
@RequiredArgsConstructor
public class TransaccionServiceImpl implements TransaccionService {

  private final TransaccionRepository transaccionRepository;
  private final TerminalRepository terminalRepository;

  @Override
  public TransaccionResponse procesarTransaccion(TransaccionRequest request) {

    // Buscar terminal asociado
    Terminal terminal = terminalRepository.findById(Integer.valueOf(request.getIdTerminal()))
        .orElseThrow(() -> new RuntimeException("Terminal no encontrado"));

    // Crear transacción y asociar terminal
    Transaccion transaccion = Transaccion.builder()
        .transactionId(request.getTransactionId() != null
            ? request.getTransactionId()
            : UUID.randomUUID().toString())
        .transactionCode(request.getTransactionCode())
        .transactionName(request.getTransactionCode().equals("01")
            ? "COMPRA"
            : "ANULACION")
        .amount(request.getAmount())
        .card(request.getCard())
        .date(request.getDate())
        .terminal(terminal)
        .status(1)  // Asignamos status inicial 1 = 'Procesado'
        .approvalCode("APPROVED123")
        .responseCode("00")
        .message("Transacción procesada exitosamente")
        .build();

    // Guardar transacción
    transaccionRepository.save(transaccion);

    // Devolver respuesta
    return TransaccionResponse.builder()
        .transactionId(transaccion.getTransactionId())
        .transactionCode(transaccion.getTransactionCode())
        .status(transaccion.getStatus())
        .amount(transaccion.getAmount())
        .card(transaccion.getCard())
        .approvalCode(transaccion.getApprovalCode())
        .responseCode(transaccion.getResponseCode())
        .message(transaccion.getMessage())
        .build();
  }
}
