package pe.izipay.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Transaccion {

  private String transactionId;
  private String transactionName;
  private String transactionCode;
  private String merchantId;
  private String merchantName;
  private int status;
  private double amount;
  private int card;
  private String date;
  private String serialPOS;
  private String approvalCode;
  private String responseCode;
  private String message;

}
