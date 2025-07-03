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
@XmlRootElement(name = "TransaccionRequest", namespace = "http://izipay.pe/ws/transaction/services")
@XmlType(propOrder = {
    "transactionId", "transactionCode", "merchantId", "merchantName",
    "amount", "card", "date", "serialPOS"
})
public class TransaccionRequest {

  private String transactionId;
  private String transactionCode;
  private double amount;
  private int card;
  private String date;
  private String idTerminal;

}
