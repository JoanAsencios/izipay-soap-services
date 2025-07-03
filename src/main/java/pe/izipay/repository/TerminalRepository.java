package pe.izipay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.izipay.model.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
}
