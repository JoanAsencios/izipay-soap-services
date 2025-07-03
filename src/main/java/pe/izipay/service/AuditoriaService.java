package pe.izipay.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuditoriaService {

  public void registrarEvento(String evento, String detalle) {
    // Persistir en una tabla audit, enviar a un Kafka/Streaming o loguear
    log.info("AUDITORIA | Evento: {} | Detalle: {}", evento, detalle);
  }
}
