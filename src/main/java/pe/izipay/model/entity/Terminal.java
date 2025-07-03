package pe.izipay.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbterminal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Terminal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_terminal")
  private Integer idTerminal;

  @Column(name = "modelo", nullable = false)
  private String modelo;

  @Column(name = "estado", nullable = false)
  private String estado;

  // Relación muchos a uno con Comercio
  @ManyToOne
  @JoinColumn(name = "id_comercio", nullable = false)
  private Comercio comercio;

  // Relación uno a muchos con Transaccion
  @OneToMany(mappedBy = "terminal")
  private List<Transaccion> transacciones;
}
