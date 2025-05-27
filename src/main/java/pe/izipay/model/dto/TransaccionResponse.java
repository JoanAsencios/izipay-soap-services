package pe.izipay.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@Getter
@Setter
@Builder
@NoArgsConstructor   // constructor sin argumentos requerido por JAXB
@AllArgsConstructor  // para el builder y otros usos

@XmlRootElement(name = "TransaccionResponse", namespace = "http://izipay.pe/ws/transaction/services")
@XmlType(propOrder = {
    "transactionId", "transactionCode", "status", "amount",
    "card", "approvalCode", "responseCode", "message"
})
public class TransaccionResponse {

  private String transactionId;
  private String transactionCode;
  private int status;
  private double amount;
  private int card;
  private String approvalCode;
  private String responseCode;
  private String message;

}
