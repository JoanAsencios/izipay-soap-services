package pe.izipay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.izipay.model.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

  // Si quieres, puedes añadir métodos personalizados como:
  // Optional<Transaccion> findByTransactionId(String transactionId);
  // List<Transaccion> findByMerchantId(String merchantId);

}
