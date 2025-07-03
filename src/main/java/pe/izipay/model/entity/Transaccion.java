package pe.izipay.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbtransaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaccion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "transaction_id", nullable = false)
  private String transactionId;

  @Column(name = "transaction_name")
  private String transactionName;

  @Column(name = "transaction_code")
  private String transactionCode;

  @Column(name = "status")
  private int status;

  @Column(name = "amount")
  private double amount;

  @Column(name = "card")
  private int card;

  @Column(name = "date")
  private String date;

  @Column(name = "approval_code")
  private String approvalCode;

  @Column(name = "response_code")
  private String responseCode;

  @Column(name = "message")
  private String message;

  // Relación muchos a uno con Terminal
  @ManyToOne
  @JoinColumn(name = "id_terminal", nullable = false)
  private Terminal terminal;
}
