package pe.izipay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.izipay.model.entity.Comercio;

public interface ComercioRepository extends JpaRepository<Comercio, Integer> {
}
