package pe.izipay.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbcomercio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comercio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_comercio")
  private Integer idComercio;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "direccion")
  private String direccion;

  @Column(name = "ruc", nullable = false)
  private String ruc;

  // Relación uno a muchos con Terminal
  @OneToMany(mappedBy = "comercio")
  private List<Terminal> terminales;
}
